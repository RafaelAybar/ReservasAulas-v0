package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public class Aula {
    private String nombre;

    public Aula(String nombre) {
        setNombre(nombre);
    }

    public Aula(Aula aula) {
        this.nombre = aula.nombre;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no es correcto");
        } else {
            // Borramos los espacios para que no puedan introducir el aula "        " por ejemplo https://www.tutorialspoint.com/java/java_string_trim.htm
            this.nombre = nombre;
        }
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