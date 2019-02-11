package org.iesalandalus.programacion.reservasaulas;

import java.util.Arrays;
import java.util.stream.Stream;

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
		if (numReservas >= MAX_RESERVAS) {
			siSupera = true;
		} else {
			siSupera = false;
		}
		return siSupera;
	}

	private boolean indiceNoSuperaCapacidad(int indice) {
		boolean siSupera;
		if (numReservas >= MAX_RESERVAS) {
			siSupera = true;
		} else {
			siSupera = false;
		}
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
}
