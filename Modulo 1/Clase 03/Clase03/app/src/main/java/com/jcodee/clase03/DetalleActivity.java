package com.jcodee.clase03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by johannfjs on 20/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DetalleActivity extends AppCompatActivity {
    private TextView tvResultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Añadimos el diseño
        setContentView(R.layout.activity_detalle);

        tvResultado = (TextView) findViewById(R.id.tvTexto);

        //Validamos que se esten trayendo datos en el intent
        if (getIntent() != null) {
            //Validamos que en el intent se traiga el dato de ruc
            if (getIntent().hasExtra("ruc")) {
                //Obtenemos el ruc
                String ruc = getIntent().getStringExtra("ruc");
                //Seteando el TextView con el valor de ruc
                tvResultado.setText(ruc);
            }
        }
    }
}
