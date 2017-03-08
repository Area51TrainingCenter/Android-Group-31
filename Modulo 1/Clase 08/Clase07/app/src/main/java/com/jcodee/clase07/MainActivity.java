package com.jcodee.clase07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jcodee.clase07.adapters.HotelAdapter;
import com.jcodee.clase07.modelos.Hotel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvLista;
    private HotelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista = (ListView) findViewById(R.id.lvLista);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Hotel> lista = new ArrayList<>();
        Hotel hotel = new Hotel();
        hotel.setId(lista.size() + 1);
        hotel.setTitulo("Four Diamond");
        hotel.setLugar("San Francisco");
        hotel.setPrecio("335");
        hotel.setRating(4);
        hotel.setRutaImagen("http://www.hotelbarcelonaprincess.com/uploads/galeriahoteles/hotel-sercotel-tbarcelona-princess-terraza-con-piscina.jpg");
        lista.add(hotel);

        Hotel hotel1 = new Hotel();
        hotel1.setId(lista.size() + 1);
        hotel1.setTitulo("Four Diamond 2");
        hotel1.setLugar("San Francisco 2");
        hotel1.setPrecio("340");
        hotel1.setRating(0);
        hotel1.setRutaImagen("http://www.hotelbarcelonaprincess.com/uploads/galeriahoteles/hotel-sercotel-tbarcelona-princess-terraza-con-piscina.jpg");
        lista.add(hotel1);

        adapter = new HotelAdapter(MainActivity.this, lista);
        lvLista.setAdapter(adapter);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, UbigeoActivity.class);
                startActivity(intent);
            }
        });
    }
}
