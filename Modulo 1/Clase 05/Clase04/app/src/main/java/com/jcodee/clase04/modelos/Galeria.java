package com.jcodee.clase04.modelos;

/**
 * Created by johannfjs on 24/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Galeria {
    private String nombre;
    private String rutaImagen;

    public Galeria() {
    }

    public Galeria(String nombre, String rutaImagen) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
