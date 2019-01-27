package org.iesalandalus.programacion.reservasaulas;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class Aulas implements Cloneable {
	private static final int MAX_AULAS = 30;
	private int numAulas = 0;

	public ArrayList<Aula> coleccionAulas = new ArrayList<>();

	public Aulas() {

	}

	public Aulas(ArrayList<Aula> coleccionAulas) {
		this.coleccionAulas = coleccionAulas;
	}

	private void setAulas(Aula aula) {
		if (aula == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		} else {
			// Comprobamos que el aula que recibimos no existe
			for (int i = 0; i < coleccionAulas.size(); i++) {
				if (coleccionAulas.get(i).getNombre().equals(aula.getNombre())) {
					throw new IllegalArgumentException("Esa aula ya existe");
				} else {
					if (numAulas == MAX_AULAS) {
						throw new IllegalArgumentException("Ya se ha alcanzado el máximo de aulas");
					}
					coleccionAulas.add(aula);
					// Incrementamos el número de aulas
					numAulas += 1;
				}
			}
		}
	}

	// Copia profunda
	private ArrayList<Aula> copiaProfundaAulas(ArrayList<Aula> coleccionAulas) {
		// Creamos el array nuevo para copiarlo
		ArrayList<Aula> copiaColeccionAulas;
		copiaColeccionAulas = (ArrayList<Aula>) coleccionAulas.stream().map(Aula::new).collect(toList());
		return copiaColeccionAulas;
	}
}