package org.iesalandalus.programacion.reservasaulas;

public enum Tramo {
	MANANA("mañana"), TARDE("tarde");
	final String cadenaAMostrar;

	Tramo(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}

}