package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public class Aula {
	private String nombre;

	public Aula(String nombre) {
		setNombre(nombre);
	}

	public Aula(Aula aula) {
		this.nombre = aula.nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no es correcto");
		} else {
			this.nombre = nombre;
		}
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Aula other = (Aula) obj;
		if (nombre == null) {
			return other.nombre == null;
		} else return nombre.equals(other.nombre);
	}

	@Override
	public String toString() {
		return "Aula [nombre=" + nombre + "]";
	}

}