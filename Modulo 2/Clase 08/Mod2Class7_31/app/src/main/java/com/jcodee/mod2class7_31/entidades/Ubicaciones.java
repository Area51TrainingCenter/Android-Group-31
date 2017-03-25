package com.jcodee.mod2class7_31.entidades;

import io.realm.RealmObject;

/**
 * Created by johannfjs on 20/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Ubicaciones extends RealmObject {
    private int id;
    private String titulo;
    private double latitud,longitud;
    private String direccion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
