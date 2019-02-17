package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public enum Tramo {
	MANANA("mañana"), TARDE("tarde");
	final String cadenaAMostrar;

	Tramo(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}

}