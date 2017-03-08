package com.jcodee.mod2class1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.mod2class1.R;
import com.jcodee.mod2class1.modelos.Datos;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johannfjs on 6/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DatoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Datos> lista;

    public DatoAdapter(Context context, ArrayList<Datos> lista) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_lista, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.tvTextoUno.setText(lista.get(position).getTextoUno());
        viewHolder.tvTextoDos.setText(lista.get(position).getTextoDos());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvTextoUno)
        TextView tvTextoUno;
        @BindView(R.id.tvTextoDos)
        TextView tvTextoDos;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
