package org.iesalandalus.programacion.reservasaulas;

import java.util.stream.Stream;

public class Aulas implements Cloneable {
	private static final int MAX_AULAS = 30;
	private int numAulas = 0;

	public Aula[] coleccionAulas;

	public Aulas() {
		Aula coleccionAulas[] = new Aula[MAX_AULAS];
	}

	public Aulas(Aula[] coleccionAulas) {
		this.coleccionAulas = coleccionAulas;
	}

	private void setAulas(Aulas aulas) {
		if (aulas == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		}
	}

	public Aula[] getAulas() {
		return coleccionAulas;
	}

	public int getNumAulas() {
		return numAulas;
	}

	public void insertar(Aula aula) {
		// int aulasLibres = 0;
		if (aula == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		} else {
			if (numAulas == MAX_AULAS) {
				throw new IllegalArgumentException("No se pueden añadir más aulas");
			}
			// Comprobamos que el aula introducida no existe
			for (int i = 0; i < coleccionAulas.length; i++) {
				if (coleccionAulas[i].equals(aula)) {
					throw new IllegalArgumentException("Esa aula ya existe");
				}
			}
			// Insertamos el aula
			for (int i = 0; i < coleccionAulas.length; i++) {
				if (coleccionAulas[i] == null) {
					coleccionAulas[i] = aula;
					break;
				}
			}
			numAulas++;
		}
	}

	private int buscarIndiceAula(Aula aula) {
		int indiceAula = -1;
		for (int i = 0; i < coleccionAulas.length; i++) {
			if (aula.equals(coleccionAulas[i])) {
				indiceAula = i;
			}
		}
		return indiceAula;

	}

	public Aula buscarAula(Aula aula) {
		if (aula == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		}

		int indiceAulaEncontrada = buscarIndiceAula(aula);

		if (indiceAulaEncontrada == -1) {
			throw new IllegalArgumentException("El aula no existe");
		}
		return coleccionAulas[indiceAulaEncontrada];
	}

	// Copia profunda
	private Aula[] copiaProfundaAulas(Aula[] coleccionAulas) {
		// Creamos el array nuevo para copiarlo
		Aula[] copiaColeccionAulas;
		// copiaColeccionAulas = (Aula[])
		// coleccionAulas.stream().map(Aula::new).collect(toList());
		copiaColeccionAulas = Stream.of(coleccionAulas).map(Aula::new).toArray(Aula[]::new);
		return copiaColeccionAulas;
	}
}