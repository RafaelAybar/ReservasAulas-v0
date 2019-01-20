package org.iesalandalus.programacion.reservasaulas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Permanencia {
	private LocalDate dia/* = LocalDate.now() */;
	private Tramo tramo;
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/mm/yyyy", Locale.getDefault());
	// String dia3 = FORMATO_DIA.format(dia);

	public Permanencia(LocalDate dia, Tramo tramo) {
		setDia(dia);
		setTramo(tramo);
	}

	public Permanencia(Permanencia permanencia) {
		this.dia = permanencia.dia;
		this.tramo = permanencia.tramo;
	}

	public LocalDate getDia() {
		return dia;

	}

	private static void setDia(LocalDate dia) {
		// Obtenemos la fecha actual, por que no tiene sentido reservar para eventos
		// pasados
		LocalDate diahoy = LocalDate.now();
		if (dia == null || dia.isBefore(diahoy)) {
			throw new IllegalArgumentException("Debes introducir una fecha válida");
		}
	}

	public Tramo getTramo(Tramo tramo) {
		return tramo;
	}

	private void setTramo(Tramo tramo) {
		if (tramo == null) {
			throw new IllegalArgumentException("No pueden existir valores nulos");
		}
		if (tramo == Tramo.MANANA) {
			this.tramo = Tramo.MANANA;
		} else if (tramo == Tramo.TARDE) {
			this.tramo = Tramo.TARDE;
		} else {
			throw new IllegalArgumentException("El valor del tramo no es correcto");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((tramo == null) ? 0 : tramo.hashCode());
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
		Permanencia other = (Permanencia) obj;
		if (dia == null) {
			if (other.dia != null) {
				return false;
			}
		} else if (!dia.equals(other.dia)) {
			return false;
		}
		if (tramo != other.tramo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Permanencia [dia=" + dia + ", tramo=" + tramo + "]";
	}

}