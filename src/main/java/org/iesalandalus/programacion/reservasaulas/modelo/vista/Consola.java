package org.iesalandalus.programacion.reservasaulas.modelo.vista;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Consola {
    private Consola() {

    }

    public static void mostrarMenu() {
        mostrarCabecera("Bienvenido a la aplicación de reservas de aulas");

        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    public static void mostrarCabecera(String mensaje) {
        System.out.println(mensaje);
    }

    public static int elegirOpcion() {
        int ordinalOpcion;
        do {
            System.out.println("Introduce una opción");
            ordinalOpcion = Entrada.entero();
        } while (!Opcion.esOrdinalValido(ordinalOpcion));

        return ordinalOpcion;
    }

    public static Aula leerAula() {
        Aula aula = new Aula(leerNombreAula());
        return aula;
    }

    public static String leerNombreAula() {
        String nombreDelAula;

        do {
            System.out.println("¿Cuál es el nombre del aula?");
            nombreDelAula = Entrada.cadena().trim();
        } while (nombreDelAula.isEmpty());

        return nombreDelAula;
    }

    public static Profesor leerProfesor() {
        String numeroTelefono = "";
        String email;
        Profesor profesor;
        char confirmaNumero;
        boolean seIntroduceNumero = false;

        do {

            System.out.println("¿Quieres introducir el nº de teléfono del profesor? s/n");
            confirmaNumero = Entrada.caracter();

            System.out.println("Introduce el email");
            email = Entrada.cadena().trim();

            if (confirmaNumero == 's') {
                System.out.println("Introduce el nº de teléfono");
                numeroTelefono = Entrada.cadena();
                seIntroduceNumero = true;
            }

            if (seIntroduceNumero) {
                profesor = new Profesor(leerNombreProfesor(), email, numeroTelefono);
            } else {
                profesor = new Profesor(leerNombreProfesor(), email, null);
            }

        } while (email.isEmpty());
        return profesor;
    }

    public static String leerNombreProfesor() {
        String nombreDelProfesor;
        do {
            System.out.println("¿Cuál es el nombre del profesor?");
            nombreDelProfesor = Entrada.cadena().trim();
        } while (nombreDelProfesor.trim().isEmpty());

        return nombreDelProfesor;
    }

    public static Tramo leerTramo() {
        int seleccion;
        do {
            System.out.println("Introduce 0 para seleccionar el tramo de mañana o 1 para el tramo de tarde");
            seleccion = Entrada.entero();
        } while (seleccion != 1 && seleccion != 0);
        return Tramo.values()[seleccion];
    }

    public LocalDate leerDia() {
        DateTimeFormatter FORMATO_DIA;
        FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault());
        LocalDate hoy = LocalDate.now();
        LocalDate fecha;
        do {
            System.out.println("Introduce la fecha en formato día, mes, año");
            String fechaIntrod = Entrada.cadena().trim();
            if (fechaIntrod == null){
                throw new IllegalArgumentException("No puede ser nulo");
            }
            // Convertimos la fecha a LocalDate

            fecha = LocalDate.parse(fechaIntrod, FORMATO_DIA);

        } while (fecha.isBefore(hoy));


        return fecha;
    }
}
