package com.jcodee.clase04.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.clase04.R;
import com.jcodee.clase04.modelos.Galeria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 24/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class GaleriaAdapter extends ArrayAdapter<Galeria> {
    private Context context;
    private ArrayList<Galeria> lista;

    public GaleriaAdapter(Context context, ArrayList<Galeria> objects) {
        super(context, R.layout.item_galeria, objects);
        this.context = context;
        this.lista = objects;
        //area5100
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_galeria, parent, false);

        SimpleDraweeView sdvImage = (SimpleDraweeView) convertView.findViewById(R.id.sdvImage);
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTexto);

        Galeria galeria = lista.get(position);

        tvTitulo.setText(galeria.getNombre());
        sdvImage.setImageURI(Uri.parse(galeria.getRutaImagen()));

        return convertView;
    }
}
