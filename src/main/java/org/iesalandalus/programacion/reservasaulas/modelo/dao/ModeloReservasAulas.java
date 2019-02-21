package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class ModeloReservasAulas {
    private Aulas aulas;
    private Profesores profesores;
    private Reservas reservas;

    public ModeloReservasAulas() {
        aulas = new Aulas();
        profesores = new Profesores();
        reservas = new Reservas();

    }

    //Aulas

    public Aula[] getAulas() {
        return aulas.getAulas();
    }

    public int getNumAulas() {
        return aulas.getNumAulas();
    }

    public String[] representarAulas() {
        return aulas.representar();
    }

    public Aula buscarAula(Aula aula) {
        return aulas.buscarAula(aula);
    }

    public void insertarAula(Aula aula) {
        aulas.insertar(aula);
    }

    public void borarAula(Aula aula) {
        aulas.borrar(aula);
    }

    //Profesores
    public Profesor[] getProfesores() {
        return profesores.getProfesores();
    }

    public int getNumProfesores() {
        return profesores.getNumProfesores();
    }

    public String[] representarProfesores() {
        return profesores.representar();
    }

    public Profesor buscarProfesor(Profesor profesor) {
        return profesores.buscar(profesor);
    }

    public void insertarProfesor(Profesor profesor) {
        profesores.insertar(profesor);
    }

    public void borrarProfesor(Profesor profesor) {
        profesores.insertar(profesor);
    }

    //Reservas
    public Reserva[] getReservas() {
        return reservas.getReservas();
    }

    public int getNumReservas() {
        return reservas.getNumReservas();
    }

    public String[] representarReservas() {
        return reservas.representar();
    }

    public Reserva buscarAula(Reserva reserva) {
        return reservas.buscar(reserva);
    }

    public void insertarReserva(Reserva reserva) {
        reservas.insertar(reserva);
    }

    public void borarReserva(Reserva reserva) {
        reservas.borrar(reserva);
    }

    public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
        return reservas.consultarDisponibilidad(aula, permanencia);
    }
}