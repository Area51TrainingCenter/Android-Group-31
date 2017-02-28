package com.jcodee.clase04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jcodee.clase04.modelos.Auto;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {
    private Spinner marca, anio;
    private EditText modelo;
    private Button registro, verTodos;
    //Variable para simular que estamos registrando en una base de datos
    static final ArrayList<Auto> listaAutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        marca = (Spinner) findViewById(R.id.spMarca);
        anio = (Spinner) findViewById(R.id.spAnio);
        modelo = (EditText) findViewById(R.id.etModelo);
        registro = (Button) findViewById(R.id.btnRegistrar);
        verTodos = (Button) findViewById(R.id.btnVerTodos);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Creamos una lista la cual almacenará los datos que se mostrarán en el spinner
        ArrayList<String> lista = new ArrayList<>();
        //Hacemos un recorrido a todos los años que esten desde 1990 hasta el 2017
        for (int i = 1990; i <= 2017; i++) {
            //Agregamos a la lista los datos
            lista.add(String.valueOf(i));
        }

        //Creamos el adapter o estructura que manejará el spinner
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                RegistroActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                lista);
        //Cambiamos la estructura del adapter por la que hemos creado
        anio.setAdapter(arrayAdapter);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getSelectedItem es para obtener el elemento seleccionado de un spinner
                //getText es para obtener el texto ingresado en un editText
                String textoMarca = marca.getSelectedItem().toString(),
                        textoModelo = modelo.getText().toString(),
                        textoAnio = anio.getSelectedItem().toString();
                Auto auto = new Auto();
                auto.setId(listaAutos.size() + 1);
                auto.setAnio(textoAnio);
                auto.setMarca(textoMarca);
                auto.setModelo(textoModelo);
                listaAutos.add(auto);

                Toast.makeText(RegistroActivity.this,
                        "Se registro correctamente.", Toast.LENGTH_SHORT).show();
            }
        });
        verTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        RegistroActivity.this, ListadoActivity.class);
                startActivity(intent);
                //finish();

            }
        });
    }
}
