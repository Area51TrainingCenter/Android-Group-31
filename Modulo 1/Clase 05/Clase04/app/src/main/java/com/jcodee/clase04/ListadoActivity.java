package com.jcodee.clase04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListadoActivity.this,
                        RegistroActivity.listaAutos.get(position).getModelo(),
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListadoActivity.this, DatosActivity.class);
                //De está forma, tendríamos que pasar dato por dato
                intent.putExtra("modelo", RegistroActivity.listaAutos.get(position).getModelo());
                //De está forma solamente pasariamos el id y en la siguiente pantalla obtendríamos los
                //datos de la lista
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });
    }
}
