package com.jcodee.clase04.modelos;

/**
 * Created by johannfjs on 22/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Auto {
    private int id;
    private String marca;
    private String modelo;
    private String anio;

    //Clic Derecho - Generate - Getter and Setter - All Options

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
