package com.jcodee.clase04;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodee.clase04.adapters.GaleriaAdapter;
import com.jcodee.clase04.modelos.Auto;
import com.jcodee.clase04.modelos.Galeria;

import java.util.ArrayList;

public class DatosActivity extends AppCompatActivity {
    private TextView tvDatos;
    private ArrayList<Galeria> lista;
    private GridView gvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        //TODO IMPORTANTE!!!!
        tvDatos = (TextView) findViewById(R.id.tvDatos);
        gvDatos = (GridView) findViewById(R.id.gvDatos);

        //getWindow().getWindowManager().getDefaultDisplay().getWidth();
        //getWindow().getWindowManager().getDefaultDisplay().getHeight();

        Toast.makeText(this, Build.MODEL.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Validamos que el intent traiga datos
        if (getIntent() != null) {
            //Obtenemos la posición que se envio a través del intent
            int posicion = getIntent().getIntExtra("position", -1);
            //Validamos que la posición sea mayor a -1
            if (posicion > -1) {
                //Obtenemos el objeto de tipo Auto según la posición enviada
                Auto auto = RegistroActivity.listaAutos.get(posicion);

                tvDatos.setText(auto.getModelo() + " - " + auto.getMarca() + " - " + auto.getAnio());
            }
        }

        lista = new ArrayList<>();

        Galeria galeria = new Galeria();
        galeria.setNombre("Nombre 1");
        galeria.setRutaImagen("http://www.paisajesbonitos.org/wp-content/uploads/2015/11/paisajes-bonitos-de-oto%C3%B1o-lago.jpg");
        lista.add(galeria);

        lista.add(new Galeria("Nombre 2", ""));

        GaleriaAdapter galeriaAdapter = new GaleriaAdapter(DatosActivity.this, lista);
        gvDatos.setAdapter(galeriaAdapter);
    }
}
