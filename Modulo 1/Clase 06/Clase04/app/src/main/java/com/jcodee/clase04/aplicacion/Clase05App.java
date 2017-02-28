package com.jcodee.clase04.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 24/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Clase05App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Inicializado la librería
        Fresco.initialize(getApplicationContext());
    }
}
