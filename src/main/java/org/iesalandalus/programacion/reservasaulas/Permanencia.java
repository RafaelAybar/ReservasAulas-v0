package org.iesalandalus.programacion.reservasaulas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Permanencia {
	private LocalDate dia = LocalDate.now();
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault());
	String dia3 = FORMATO_DIA.format(dia);

}