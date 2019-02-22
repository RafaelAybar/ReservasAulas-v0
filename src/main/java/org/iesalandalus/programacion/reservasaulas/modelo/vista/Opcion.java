package org.iesalandalus.programacion.reservasaulas.modelo.vista;

// https://stackoverflow.com/questions/13659217/where-is-the-documentation-for-the-values-method-of-enum
public enum Opcion {
    SALIR("Salir") {
        public void ejecutar() {
            vista.comenzar();
        }
    },
    INSERTAR_AULA("Insertar aula") {
        public void ejecutar() {
            vista.insertarAula();
        }
    },
    BORRAR_AULA("Borrar aula") {
        public void ejecutar() {
            vista.borrarAula();
        }
    },
    BUSCAR_AULA("Buscar aula") {
        public void ejecutar() {
            vista.buscarAula();
        }
    },
    LISTAR_AULAS("Listar aulas") {
        public void ejecutar() {
            vista.listarAulas();
        }
    },
    INSERTAR_PROFESOR("Insertar profesor") {
        public void ejecutar() {
            vista.insertarProfesor();
        }
    },
    BORRAR_PROFESOR("Borrar profesor") {
        public void ejecutar() {
            vista.borrarProfesor();
        }
    },
    BUSCAR_PROFESOR("Buscar profesor") {
        public void ejecutar() {
            vista.buscarProfesor();
        }
    },
    LISTAR_PROFESORES("Listar profesores") {
        public void ejecutar() {
            vista.listarProfesores();
        }
    },
    INSERTAR_RESERVA("Insertar reserva") {
        public void ejecutar() {
            vista.realizarReservas();
        }
    },
    BORRAR_RESERVA("Borrar reserva") {
        public void ejecutar() {
            vista.anularReserva();
        }
    },
    LISTAR_RESERVAS("Listar reservas") {
        public void ejecutar() {
            vista.listarReservas();
        }
    },
    LISTAR_RESERVAS_AULAS("Listar reservas de las aulas") {
        public void ejecutar() {
            vista.listarReservasAulas();
        }
    },
    LISTAR_RESERVAS_PROFESORES("Listar reservas de los profesores") {
        public void ejecutar() {
            vista.listarReservasProfesores();
        }
    },
    LISTAR_RESERVAS_PERMANENCIA("Listar reservas con una permanencia") {
        public void ejecutar() {
            vista.listarReservasPermanencia();
        }
    },
    CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad") {
        public void ejecutar() {
            vista.consultarDisponibilidad();
        }
    };

    private static IUTextual vista;
    private String mensajeAMostrar;

    //Private con el constructor en el enum es redundante
    Opcion(String mensajeAMostrar) {
        if (mensajeAMostrar == null) {
            throw new IllegalArgumentException("No puede ser nulo");
        }
        this.mensajeAMostrar = mensajeAMostrar;
    }

    protected static void setVista(IUTextual vista) {
        Opcion.vista = vista;
    }

    public static boolean esOrdinalValido(int ordinal) {
        boolean esValido = true;
        if (ordinal < 0) {
            esValido = false;
        }
        return esValido;
    }

    public static Opcion getOpcionSegunOrdinal(int ordinal){
        if (esOrdinalValido(ordinal) == false){
            throw new IllegalArgumentException("Opción incoherente");
        }
        return values()[ordinal];
    }

    public String getMensajeAMostrar() {
        return mensajeAMostrar;
    }

    public abstract void ejecutar();

    @Override
    public String toString() {
        return "Opcion{" +
                "mensajeAMostrar='" + mensajeAMostrar + '\'' +
                '}';
    }
}