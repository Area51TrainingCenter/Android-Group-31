package com.jcodee.clase04;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jcodee.clase04.adapters.DetalleAdapter;

public class DetalleDosActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private DetalleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_dos);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter = new DetalleAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //Verificamos que el intent no llegue vacio
        if (getIntent() != null) {
            //Obtenemos el dato o la posición que se está enviando
            int posicion = getIntent().getIntExtra("posicion", -1);
            //Validamos que el dato sea mayor a -1
            if (posicion > -1) {
                //Indicamos al viewPager que el elemento que estamos mostrando sea
                //el que seleccionamos
                viewPager.setCurrentItem(posicion);
            }
        }
    }
}
