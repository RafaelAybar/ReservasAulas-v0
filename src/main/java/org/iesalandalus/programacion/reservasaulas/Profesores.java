package org.iesalandalus.programacion.reservasaulas;

import java.util.stream.Stream;

public class Profesores {
	private static final int MAX_PROFESORES = 25;
	private int numProfesores = 0;

	private Profesor[] coleccionProfesores = new Profesor[MAX_PROFESORES];

	public Profesores() {

	}

	public Profesores(Profesores profesores) {

	}

	private void setProfesores(Profesores profesores) {

	}

	private Profesor[] copiaProfundaProfesores(Profesor coleccionProfesores) {
		Profesor[] copiaArrayProfesores = Stream.of(coleccionProfesores).map(Profesor::new).toArray(Profesor[]::new);
		return copiaArrayProfesores;
	}

	public Profesor[] getProfesores() {
		return coleccionProfesores;
	}

	public int getNumProfesores() {
		return numProfesores;
	}

	public void insertar(Profesor profesor) {
	}

	private int buscarIndiceProfesor(Profesor profesor) {
		int indiceProfesor = -1;
		for (int i = 0; i < numProfesores; i++) {
			if (profesor.equals(coleccionProfesores[i])) {
				indiceProfesor = i;
			}
		}
		return indiceProfesor;
	}
}
