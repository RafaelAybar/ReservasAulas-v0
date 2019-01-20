package org.iesalandalus.programacion.reservasaulas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profesor {
	private static final String ER_TELEFONO = "^[9]+[0-9]{8}|[6]+[0-9]{8}";
	private static final String ER_CORREO = "^[A-Z0-9._%+-]+@[A-Z0-9.-]*$";
	private String nombre;
	private String correo;
	private String telefono;

	Profesor(String nombre, String correo, String telefono) {
		setNonbre(nombre);
		setCorreo(correo);
		setTelefono(telefono);
	}

	Profesor(Profesor profesor) {
		this.nombre = profesor.nombre;
		this.telefono = profesor.telefono;
		this.correo = profesor.correo;
	}

	private void setNonbre(String nombre) {

		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no es válido");
		}
	}

	public void setCorreo(String correo) {
		Pattern patron = Pattern.compile(ER_CORREO, Pattern.CASE_INSENSITIVE);
		Matcher correoIntorducido = patron.matcher(correo);
		if (correo == null || correoIntorducido.matches() == false) {
			throw new IllegalArgumentException("El correo no es válido");
		} else {
			this.correo = correo;
		}
	}

	public void setTelefono(String telefono) {
		Pattern patronTelefono = Pattern.compile(ER_TELEFONO);
		Matcher telefonoIntroducido = patronTelefono.matcher(telefono);

		if (telefono == null) {
			this.telefono = "No introducido";
		} else if (telefonoIntroducido.matches() == false) {
			throw new IllegalArgumentException("El teléfono no es válido");
		} else {
			this.telefono = telefono;
		}
	}

	public String getNombre() {
		return nombre;

	}

	public String getCorreo() {
		return correo;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
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
		Profesor other = (Profesor) obj;
		if (correo == null) {
			if (other.correo != null) {
				return false;
			}
		} else if (!correo.equals(other.correo)) {
			return false;
		}
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + "]";
	}

}