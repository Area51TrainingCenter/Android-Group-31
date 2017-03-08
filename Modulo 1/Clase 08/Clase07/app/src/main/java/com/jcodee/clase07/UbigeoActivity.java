package com.jcodee.clase07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.jcodee.clase07.adapters.SpinnerAdapter;
import com.jcodee.clase07.views.EditTextCustom;

import java.util.ArrayList;

public class UbigeoActivity extends AppCompatActivity {
    private Spinner spDepartamento, spProvincia;
    private Spinner spDatos, spDatosCustom;
    private EditTextCustom etProvinciaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubigeo);

        spDepartamento = (Spinner) findViewById(R.id.spDepartamento);
        spProvincia = (Spinner) findViewById(R.id.spProvincia);
        etProvinciaSeleccionada = (EditTextCustom) findViewById(R.id.etProvinciaSeleccionada);
        spDatos = (Spinner) findViewById(R.id.spDatos);
        spDatosCustom = (Spinner) findViewById(R.id.spDatosCustom);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<String> datos = new ArrayList<>();
        datos.add("Texto 1");
        datos.add("Texto 2");
        datos.add("Texto 3");

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                UbigeoActivity.this, R.layout.item_spinner_dropdown, datos);
        spDatos.setAdapter(arrayAdapter);

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(UbigeoActivity.this, datos);
        spDatosCustom.setAdapter(spinnerAdapter);


        spDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Creamos una variable entera para poder guardar la lista que vamos a mostrar
                int listaSeleccion = 0;

                //Validamos que la posición del spinner que seleccionamos sea 1 o 2
                if (position == 1) {
                    listaSeleccion = R.array.departamento_lima;
                } else if (position == 2) {
                    listaSeleccion = R.array.departamento_ica;
                }

                if (listaSeleccion > 0) {
                    //Creamos la nueva estructura de nuestro adapter
                    ArrayAdapter arrayAdapter = new ArrayAdapter(UbigeoActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            getResources().getStringArray(listaSeleccion));
                    //Seteamos el spinner con el adapter que hemos creado
                    spProvincia.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String provincia = spProvincia.getSelectedItem().toString();
                    etProvinciaSeleccionada.setText(provincia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
