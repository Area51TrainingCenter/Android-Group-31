package com.jcodee.mod2class4.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.mod2class4.R;
import com.jcodee.mod2class4.modelos.Datos;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 13/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DatosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Datos> lista;

    public DatosAdapter(Context context, ArrayList<Datos> lista) {
        this.context = context;
        this.lista = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitulo)
        TextView tvTitulo;
        @BindView(R.id.tvDescripcion)
        TextView tvDescripcion;
        @BindView(R.id.sdvImagen)
        SimpleDraweeView sdvImagen;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //Es donde se carga la vista -> getView
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.item_datos, parent, false);
        return new MyViewHolder(convertView);
    }

    //Es donde se tiene la vista y se cambia los datos
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Datos datos = lista.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.tvTitulo.setText(datos.getTitulo());
        myViewHolder.tvDescripcion.setText(datos.getDescripcion());
        myViewHolder.sdvImagen.setImageURI(Uri.parse(datos.getRutaImagen()));
    }

    //Es la cantidad de elementos que va a tener la lista
    @Override
    public int getItemCount() {
        return lista.size();
    }
}
