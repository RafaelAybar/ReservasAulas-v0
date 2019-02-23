package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.Arrays;
import java.util.stream.Stream;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

public class Profesores {
	private static final int MAX_PROFESORES = 25;
	private int numProfesores = 0;

	private Profesor[] coleccionProfesores;

	public Profesores() {
		coleccionProfesores = new Profesor[MAX_PROFESORES];
	}

	public Profesores(Profesores profesores) {
		if (profesores == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		}
	}

	private void setProfesores(Profesores profesores) {
		if (profesores == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		}
	}

	private Profesor[] copiaProfundaProfesores(Profesor[] coleccionProfesores) {
		Profesor[] copiaArrayProfesores = Stream.of(coleccionProfesores).map(Profesor::new).toArray(Profesor[]::new);
		return copiaArrayProfesores;
	}

	public Profesor[] getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}

	public int getNumProfesores() {
		return numProfesores;
	}

	public void insertar(Profesor profesor) {
		// Comprobamos que no existe
		if (buscarIndiceProfesor(profesor) == -1) {
			coleccionProfesores[numProfesores] = profesor;
			numProfesores++;
		} else {
			throw new IllegalArgumentException("El profesor ya existe");
		}
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

	private boolean indiceNoSuperaTamano(int indice) {
		boolean siSupera;
        siSupera = indice >= MAX_PROFESORES;
		return siSupera;
	}

	private boolean indiceNoSuperaCapacidad(int indice) {
		boolean siSupera;
        siSupera = indice >= MAX_PROFESORES;
		return siSupera;
	}

	public Profesor buscar(Profesor profesor) {

		Profesor profesorEncontrado;
		int indice = buscarIndiceProfesor(profesor);
		if (profesor == null || indice == -1) {
			throw new IllegalArgumentException("El profesor introducdo no existe");
		} else {
			profesorEncontrado = coleccionProfesores[indice];
		}
		return profesorEncontrado;
	}

	public void borrar(Profesor profesor) {
		int indiceprofesorEncontrado = buscarIndiceProfesor(profesor);

		if (profesor == null || indiceprofesorEncontrado == -1) {
			throw new IllegalArgumentException("No se ha podido encontrar");
		} else {
			coleccionProfesores[indiceprofesorEncontrado] = coleccionProfesores[numProfesores];
			numProfesores--;
		}
	}

	private void desplazarUnaPosicionHaciaLaIzquierada() {

	}

	public String[] representar() {
		String[] arrayString = Arrays.copyOf(coleccionProfesores, coleccionProfesores.length, String[].class);
		return arrayString;
	}
}