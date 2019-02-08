package org.iesalandalus.programacion.reservasaulas;

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

		if (reserva == null || indiceReserva != -1) {
			throw new IllegalArgumentException("Ese valor ya existe");
		}
		coleccionReservas[numReservas] = reserva;
		numReservas++;
	}

	private int buscarIndiceReserva(Reserva reserva) {
		int indiceReservaEncontrado = -1;
		for (int i = 0; i < coleccionReservas.length; i++) {
			if (coleccionReservas[i].equals(reserva)) {
				indiceReservaEncontrado = i;
			}
		}
		return indiceReservaEncontrado;
	}
}
