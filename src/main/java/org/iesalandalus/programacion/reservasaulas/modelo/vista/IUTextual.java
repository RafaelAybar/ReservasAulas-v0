package org.iesalandalus.programacion.reservasaulas.modelo.vista;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class IUTextual {
    private String ERROR = "¡Error!";
    private String NOMBRE_VALIDO = "Nombre válido";
    private String CORREO_VALIDO = "Correo válido";
    private ModeloReservasAulas modelo;

    public IUTextual() {
        modelo = new ModeloReservasAulas();
        Opcion.setVista(this);
    }

    public void comenzar() {
        int ordinalOpcion; //¿?
        do {
            Consola.mostrarMenu();
            System.out.println("Elige una opción");
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());
    }

    public void salir() {
        System.out.println("Se ha cerrado la aplicación");
        System.exit(0);
    }

    public void insertarAula() {
        Consola.mostrarCabecera("Insertar Aula");
    }

    public void borrarAula() {

    }

    public void buscarAula() {

    }

    public void listarAulas() {

    }

    public void insertarProfesor() {

    }

    public void borrarProfesor() {

    }

    public void buscarProfesor() {

    }

    public void listarProfesores() {

    }

    private Reserva leerReserva(Profesor profesor) {
        return null;
    }

    public void realizarReservas() {

    }

    public void anularReserva() {

    }

    public void listarReservas() {

    }

    public void listarReservasAulas() {

    }

    public void listarReservasProfesores() {

    }

    public void listarReservasPermanencia() {

    }

    public void consultarDisponibilidad() {

    }
}
