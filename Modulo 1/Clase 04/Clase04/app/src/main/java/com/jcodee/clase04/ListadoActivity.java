package com.jcodee.clase04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.jcodee.clase04.adapters.AutoAdapter;

public class ListadoActivity extends AppCompatActivity {
    private ListView lvLista;
    private AutoAdapter autoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lvLista = (ListView) findViewById(R.id.lvLista);
    }

    @Override
    protected void onResume() {
        super.onResume();

        autoAdapter = new AutoAdapter(ListadoActivity.this, RegistroActivity.listaAutos);
        lvLista.setAdapter(autoAdapter);
    }
}
