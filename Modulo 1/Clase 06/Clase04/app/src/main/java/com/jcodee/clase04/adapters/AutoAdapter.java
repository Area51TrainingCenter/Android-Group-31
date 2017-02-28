package com.jcodee.clase04.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.clase04.R;
import com.jcodee.clase04.modelos.Auto;

import java.util.ArrayList;

/**
 * Created by johannfjs on 22/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class AutoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Auto> lista;

    public AutoAdapter(Context context, ArrayList<Auto> lista) {
        this.context = context;
        this.lista = lista;
    }

    //Es el metodo que sabe cuantos elementos tiene tu lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //Es el metodo que obtiene un elemento de la lista según la posición
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    //Es el metodo que obtiene el identificador unico de cada elemento de la lista
    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    //Es el metodo encargado de realizar el diseño y vincularlo con los datos a mostrar
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Cargamos el diseño a nuestra vista
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_auto_left, parent, false);

        //Vinculamos las variables a nuestro diseño
        TextView marca = (TextView) convertView.findViewById(R.id.tvMarca);
        TextView modelo = (TextView) convertView.findViewById(R.id.tvModelo);
        TextView anio = (TextView) convertView.findViewById(R.id.tvAnio);

        //Obtenemos los datos de un elemento según la posición
        Auto auto = (Auto) getItem(position);
        marca.setText(auto.getMarca());
        modelo.setText(auto.getModelo());
        anio.setText(auto.getAnio());

        return convertView;
    }
}
