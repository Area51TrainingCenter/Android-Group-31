package com.jcodee.clase07.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.clase07.R;
import com.jcodee.clase07.modelos.Hotel;
import com.jcodee.clase07.views.TextViewCustom;

import java.util.ArrayList;

/**
 * Created by johannfjs on 1/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class HotelAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Hotel> lista;

    public HotelAdapter(Context context, ArrayList<Hotel> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    class ViewHolder {
        TextView tvTitulo;
        TextView tvLugar;
        TextViewCustom tvPrecio;
        RatingBar rbValoracion;
        SimpleDraweeView sdvImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Creamos un objeto de tipo ViewHolder
        ViewHolder viewHolder;

        //Validamos que el diseño este cargado o no
        if (convertView == null) {
            //Cargamos el diseño
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_hotel, parent, false);
            //Inciializamos el viewHolder
            viewHolder = new ViewHolder();
            //Vinculamos los componentes con las variables que creamos
            viewHolder.tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
            viewHolder.tvLugar = (TextView) convertView.findViewById(R.id.tvLugar);
            viewHolder.tvPrecio = (TextViewCustom) convertView.findViewById(R.id.tvPrecio);
            viewHolder.rbValoracion = (RatingBar) convertView.findViewById(R.id.rbValoracion);
            viewHolder.sdvImagen = (SimpleDraweeView) convertView.findViewById(R.id.sdvImagen);

            //Cambiar el tipo de letra
            Typeface typeface = Typeface.createFromAsset(
                    context.getAssets(), "fonts/Aller_Rg.ttf");
            viewHolder.tvTitulo.setTypeface(typeface);

            typeface = Typeface.createFromAsset(
                    context.getAssets(), "fonts/Raleway_Regular.ttf");
            viewHolder.tvLugar.setTypeface(typeface);

            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Hotel hotel = (Hotel) getItem(position);
        viewHolder.tvTitulo.setText(hotel.getTitulo());
        viewHolder.tvLugar.setText(hotel.getLugar());
        viewHolder.tvPrecio.setText(hotel.getPrecio());
        viewHolder.sdvImagen.setImageURI(Uri.parse(hotel.getRutaImagen()));

        if (hotel.getRating() > 0) {
            viewHolder.rbValoracion.setVisibility(View.VISIBLE);
            viewHolder.rbValoracion.setRating(hotel.getRating());
        } else {
            /*
             visible    es para que se pueda visualizar
             invisible  no se visualiza pero ocupa un espacio en el layout
             gone       no se visualiza y no ocupa espacio
            */
            viewHolder.rbValoracion.setVisibility(View.GONE);
        }

        return convertView;
    }
}
