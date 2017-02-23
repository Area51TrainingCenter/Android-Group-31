package com.jcodee.clase03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
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
            StringBuilder textoMostrar = new StringBuilder();
            //Validamos que en el intent se traiga el dato de ruc
            if (getIntent().hasExtra("ruc")) {
                //Obtenemos el ruc
                textoMostrar.append(getIntent().getStringExtra("ruc"));
                textoMostrar.append("<br/>");
            }
            if (getIntent().hasExtra("razon_social")) {
                textoMostrar.append(getIntent().getStringExtra("razon_social"));
                textoMostrar.append("<br/>");
            }
            if (getIntent().hasExtra("estado")) {
                textoMostrar.append(getIntent().getStringExtra("estado"));
                textoMostrar.append("<br/>");
            }
            if (getIntent().hasExtra("notificacion")) {
                boolean notificacion = getIntent().getBooleanExtra("notificacion", false);
                textoMostrar.append(notificacion ? "Si" : "No");
                textoMostrar.append("<br/>");
            }

            //Seteando el TextView con el valor de ruc
            tvResultado.setText(Html.fromHtml(textoMostrar.toString()));
        }
    }
}
