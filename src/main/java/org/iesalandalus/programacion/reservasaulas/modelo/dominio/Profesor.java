package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profesor {
    private static final String ER_TELEFONO = "^[9]+[0-9]{8}|[6]+[0-9]{8}";
    private static final String ER_CORREO = "^[A-Z0-9._%+-]+@[A-Z0-9.-]*$";
    private String nombre;
    private String correo;
    private String telefono;

    public Profesor(String nombre, String correo, String telefono) {
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public Profesor(Profesor profesor) {
        this.nombre = profesor.nombre;
        this.telefono = profesor.telefono;
        this.correo = profesor.correo;
    }

    public String getNombre() {
        return nombre;

    }

    private void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no es válido");
        }
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {

        if (correo == null) {
            throw new IllegalArgumentException("El correo no puede ser nulo");
        } else {
            Pattern patron = Pattern.compile(ER_CORREO, Pattern.CASE_INSENSITIVE);
            Matcher correoIntorducido = patron.matcher(correo);
            if (correoIntorducido.matches() == false) {
                throw new IllegalArgumentException("El correo no es válido");
            }
            this.correo = correo;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (telefono == null) {
            this.telefono = null;
        } else {

            Pattern patronTelefono = Pattern.compile(ER_TELEFONO);
            Matcher telefonoIntroducido = patronTelefono.matcher(telefono);
            if (telefonoIntroducido.matches() == false) {
                throw new IllegalArgumentException("El teléfono no es válido");
            }
            this.telefono = telefono;
        }
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
            return other.nombre == null;
        } else return nombre.equals(other.nombre);
    }

    @Override
    public String toString() {
        return "Profesor [nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + "]";
    }

}