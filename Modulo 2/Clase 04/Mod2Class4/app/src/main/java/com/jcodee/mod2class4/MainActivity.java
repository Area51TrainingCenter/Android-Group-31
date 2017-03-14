package com.jcodee.mod2class4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodee.mod2class4.adapters.DatosAdapter;
import com.jcodee.mod2class4.modelos.Datos;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvDatos)
    RecyclerView rvDatos;

    private DatosAdapter datosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Datos> lista = new ArrayList<>();
        Datos datos=new Datos();
        datos.setId(1);
        datos.setTitulo("Titulo");
        datos.setDescripcion("Descripción");
        datos.setRutaImagen("");
        lista.add(datos);

        datosAdapter = new DatosAdapter(MainActivity.this, lista);
        rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvDatos.setAdapter(datosAdapter);
    }
}