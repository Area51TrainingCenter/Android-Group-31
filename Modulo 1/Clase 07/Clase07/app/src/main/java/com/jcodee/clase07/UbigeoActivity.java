package com.jcodee.clase07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class UbigeoActivity extends AppCompatActivity {
    private Spinner spDepartamento, spProvincia;
    private EditText etProvinciaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubigeo);

        spDepartamento = (Spinner) findViewById(R.id.spDepartamento);
        spProvincia = (Spinner) findViewById(R.id.spProvincia);
        etProvinciaSeleccionada = (EditText) findViewById(R.id.etProvinciaSeleccionada);
    }

    @Override
    protected void onResume() {
        super.onResume();

        spDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Creamos una variable entera para poder guardar la lista que vamos a mostrar
                int listaSeleccion = 0;

                //Validamos que la posición del spinner que seleccionamos sea 0 o 1
                if (position == 0) {
                    listaSeleccion = R.array.departamento_lima;
                } else if (position == 1) {
                    listaSeleccion = R.array.departamento_ica;
                }

                //Creamos la nueva estructura de nuestro adapter
                ArrayAdapter arrayAdapter = new ArrayAdapter(UbigeoActivity.this,
                        android.R.layout.simple_spinner_dropdown_item,
                        getResources().getStringArray(listaSeleccion));
                //Seteamos el spinner con el adapter que hemos creado
                spProvincia.setAdapter(arrayAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
