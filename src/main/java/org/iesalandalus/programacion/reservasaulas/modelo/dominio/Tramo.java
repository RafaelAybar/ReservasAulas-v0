package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public enum Tramo {
	MANANA("mañana"), TARDE("tarde");
	private String cadenaAMostrar;

	Tramo(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}

	@Override
	public String toString() {
		//No pasa los test si se deja el método toString generado por defecto
		return cadenaAMostrar;
	}
}