package com.jcodee.clase04;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodee.clase04.adapters.GaleriaAdapter;
import com.jcodee.clase04.modelos.Auto;
import com.jcodee.clase04.modelos.Galeria;

import java.util.ArrayList;

public class DatosActivity extends AppCompatActivity {
    private TextView tvDatos;
    public static ArrayList<Galeria> lista;
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

        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                //AlertDialog
                //Declaramos un alerDialog
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DatosActivity.this);
                //Cambiamos el titulo del dialogo
                alertDialog.setTitle("Opciones");
                //Cambiamos el texto a mostrar del dialogo
                alertDialog.setMessage("Seleccione una opción");
                //Añadimos una opción
                alertDialog.setPositiveButton("Detalle Dos", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(DatosActivity.this, DetalleDosActivity.class);
                        intent.putExtra("posicion",position);
                        startActivity(intent);

                        Toast.makeText(DatosActivity.this, "Cargo Detalle dos", Toast.LENGTH_SHORT).show();
                    }
                });
                //Añadimos otra opción
                alertDialog.setNegativeButton("Detalle Uno", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Decimos a que pantalla vamos a ir
                        Intent intent = new Intent(DatosActivity.this, DetalleActivity.class);

                        //Agregamos flags para que se limpie la aplicación y se cargue
                        //desde el inicio
                        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        intent.putExtra("rutaImagen", lista.get(position).getRutaImagen());
                        intent.putExtra("nombre", lista.get(position).getNombre());

                        //Ejecutamos la acción a realizar del cambio de pantalla
                        startActivity(intent);
                        //finish();

                    }
                });
                //Está linea es para mostrar el dialogo
                alertDialog.create().show();

            }
        });
    }
}
