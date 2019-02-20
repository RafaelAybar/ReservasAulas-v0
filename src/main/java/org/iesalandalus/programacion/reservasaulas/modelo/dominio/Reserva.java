package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public class Reserva {
	private Profesor profesor;
	private Aula aula;
	private Permanencia permanencia;

	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}

	public Reserva(Reserva reserva) {
		this.profesor = reserva.profesor;
		this.aula = reserva.aula;
		this.permanencia = reserva.permanencia;
	}

	private void setProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new IllegalArgumentException("No pueden haber valores nulos");
		} else {
			this.profesor = profesor;
		}
	}

	public Profesor getProfesor() {
		return profesor;
	}

	private void setAula(Aula aula) {
		if (aula == null) {
			throw new IllegalArgumentException("No pueden haber valores nulos");
		} else {
			this.aula = aula;
		}
	}

	public Aula getAula() {
		return aula;
	}

	private void setPermanencia(Permanencia permanencia) {
		if (permanencia == null) {
			throw new IllegalArgumentException("No pueden haber valores nulos");
		} else {
			this.permanencia = permanencia;
		}
	}

	public Permanencia getPermanencia() {
		return permanencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((permanencia == null) ? 0 : permanencia.hashCode());
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
		Reserva other = (Reserva) obj;
		if (aula == null) {
			if (other.aula != null) {
				return false;
			}
		} else if (!aula.equals(other.aula)) {
			return false;
		}
		if (permanencia == null) {
            return other.permanencia == null;
		} else return permanencia.equals(other.permanencia);
    }

	@Override
	public String toString() {
		return "Reserva [profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + "]";
	}
}