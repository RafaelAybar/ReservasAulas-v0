package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.Arrays;
import java.util.stream.Stream;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

public class Aulas implements Cloneable {
	private static final int MAX_AULAS = 30;
	private int numAulas = 0;

	public Aula[] coleccionAulas;
	private Aulas aulas;

	public Aulas(Aulas aulas1) {
		coleccionAulas = new Aula[MAX_AULAS];
	}

	public Aulas(Aula[] coleccionAulas) {
		this.coleccionAulas = coleccionAulas;
	}

	private void setAulas(Aulas aulas) {
		if (aulas == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		}
		this.aulas = aulas;
	}

	public Aula[] getAulas() {
		return coleccionAulas;
	}

	public int getNumAulas() {
		return numAulas;
	}

	public void insertar(Aula aula) {
		if (aula == null || indiceNoSuperaTamano() == true) {
			throw new IllegalArgumentException("Ni puede ser nulo, ni estar lleno");
		} else {

			if (buscarIndiceAula(aula) == -1) {
				coleccionAulas[numAulas] = aula;
				numAulas++;
			} else {
				throw new IllegalArgumentException("El profesor ya existe");
			}
		}
	}

	private int buscarIndiceAula(Aula aula) {
		int indiceAula = -1;
		for (int i = 0; i < MAX_AULAS; i++) {
			if (aula.equals(coleccionAulas[i])) {
				indiceAula = i;
			}
		}
		return indiceAula;
	}

	private boolean indiceNoSuperaTamano() {
		boolean siSupera;
		siSupera = numAulas >= MAX_AULAS;
		return siSupera;
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

	private boolean indiceNoSuperaCantidad(int indice) {
		boolean noSupera;
		noSupera = indice >= MAX_AULAS;
		return noSupera;
	}

	public void borrar(Aula aula) {
		int indiceAulaEncontrada = buscarIndiceAula(aula);

		if (aula == null || indiceAulaEncontrada == -1) {
			throw new IllegalArgumentException("No se ha podido encontrar");
		} else {
			coleccionAulas[indiceAulaEncontrada] = coleccionAulas[numAulas];
			numAulas--;
		}
	}

	// Copia profunda
	private Aula[] copiaProfundaAulas(Aula[] coleccionAulas) {
		// Creamos el array nuevo para copiarlo
		Aula[] copiaColeccionAulas;

		// Copiamos el array
		copiaColeccionAulas = Stream.of(coleccionAulas).map(Aula::new).toArray(Aula[]::new);
		return copiaColeccionAulas;
	}

	public String[] representar() {
		String[] arrayString = Arrays.copyOf(coleccionAulas, coleccionAulas.length, String[].class);
		return arrayString;
	}
}