package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.Arrays;
import java.util.stream.Stream;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.*;

public class Reservas {
	// 2 reservas por día x 251 días laborables/año
	// http://www.dias-laborables.es/dias_laborables_feriados_2019.htm
	private static final int MAX_RESERVAS = 502;
	private int numReservas = 0;
	private Reserva[] coleccionReservas;

	public Reservas() {
		coleccionReservas = new Reserva[MAX_RESERVAS];
	}

	public Reservas(Reservas reservas) {
		// this.reservas = reservas;
	}

	private void setReservas(Reservas reservas) {
		if (reservas == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		}
	}

	private Reserva[] copiaProfundaReservas(Reserva coleccionReservas) {
		Reserva[] copiaArrayReservas = Stream.of(coleccionReservas).map(Reserva::new).toArray(Reserva[]::new);
		return copiaArrayReservas;
	}

	public Reserva[] getReservas() {
		return coleccionReservas;
	}

	public int getNumReservas() {
		return numReservas;
	}

	public void insertar(Reserva reserva) {
		int indiceReserva = buscarIndiceReserva(reserva);

		if (indiceReserva != -1) {
			throw new IllegalArgumentException("Ese valor ya existe");
		}
		if (indiceNoSuperaTamano(numReservas) == true) {
			throw new IllegalArgumentException("Ya no se pueden registrar más reservas");
		}
		coleccionReservas[numReservas] = reserva;
		numReservas++;
	}

	private int buscarIndiceReserva(Reserva reserva) {
		if (reserva == null) {
			throw new IllegalArgumentException("No puede ser nulo");
		}
		int indiceReservaEncontrado = -1;
		for (int i = 0; i < coleccionReservas.length; i++) {
			if (coleccionReservas[i].equals(reserva)) {
				indiceReservaEncontrado = i;
			}
		}
		return indiceReservaEncontrado;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		boolean siSupera;
		siSupera = numReservas >= MAX_RESERVAS;
		return siSupera;
	}

	private boolean indiceNoSuperaCapacidad(int indice) {
		boolean siSupera;
		siSupera = numReservas >= MAX_RESERVAS;
		return siSupera;
	}

	public Reserva buscar(Reserva reserva) {
		int indice = buscarIndiceReserva(reserva);
		if (indice == -1) {
			throw new IllegalArgumentException("No se ha encontrado ");
		}
		Reserva reservaEncontrada = coleccionReservas[indice];
		return reservaEncontrada;
	}

	private void borrar(Reserva reserva) {
		int indice = buscarIndiceReserva(reserva);
		if (indice == -1) {
			throw new IllegalArgumentException("No se ha encontrado la reserva");
		}
		coleccionReservas[indice] = coleccionReservas[numReservas];
		numReservas--;
	}

	private void desplazarUnaPosicionHacialaIzquierda(int indice) {

	}

	public String[] representar() {
		String[] arrayString = Arrays.copyOf(coleccionReservas, coleccionReservas.length, String[].class);
		return arrayString;
	}

	public Reserva[] getReservasProfesor(Profesor profesor){
		if (profesor == null){
			throw new IllegalArgumentException("No puede ser nulo");
		}
		int contadorProfesoresEncontrados = -1;
		Reserva[] reservasDelProfesor = new Reserva[MAX_RESERVAS];
		// Comprobamos que existe
		for (int i = 0; i<= numReservas; i++){
            if (coleccionReservas[i].getProfesor().equals(profesor)){
                contadorProfesoresEncontrados++;
                reservasDelProfesor[contadorProfesoresEncontrados]= coleccionReservas[i];
            }
		}
		if (contadorProfesoresEncontrados == -1) throw new IllegalArgumentException("No se han encontrado reservas");
		return reservasDelProfesor;
	}

	public Reserva[] getReservasAula(Aula aula){
        if (aula == null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
        int contadorAulasEncontradas = -1;
        Reserva[] reservasDelAula = new Reserva[MAX_RESERVAS];
        // Comprobamos que existe
        for (int i = 0; i<= numReservas; i++){
            if (coleccionReservas[i].getAula().equals(aula)){
                contadorAulasEncontradas++;
                reservasDelAula[contadorAulasEncontradas]= coleccionReservas[i];
            }
        }
        if (contadorAulasEncontradas == -1) throw new IllegalArgumentException("No se han encontrado reservas");
        return reservasDelAula;
    }

    public Reserva[] getReservasPermanencia(Permanencia permanencia){
        if (permanencia == null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
        int contadorPermanencia = -1;
        Reserva[] reservasPermanencia = new Reserva[MAX_RESERVAS];
        // Comprobamos que existe
        for (int i = 0; i<= numReservas; i++){
            if (coleccionReservas[i].getAula().equals(reservasPermanencia)){
                contadorPermanencia++;
                reservasPermanencia[contadorPermanencia]= coleccionReservas[i];
            }
        }
        if (contadorPermanencia == -1) throw new IllegalArgumentException("No se han encontrado reservas");
        return reservasPermanencia;
    }

    public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia){
	    if (aula == null || permanencia == null){
	        throw  new IllegalArgumentException("No pueden haber valores nulos");
        }
        boolean estaDisponible = true;
        // Comprobamos que el aula NO esté reservada
        for (int i = 0; i<= numReservas; i++){
            if (coleccionReservas[i].getAula().equals(aula) && coleccionReservas[i].getPermanencia().equals(permanencia)){
                estaDisponible = false;
            }
        }
        return estaDisponible;
    }
}
