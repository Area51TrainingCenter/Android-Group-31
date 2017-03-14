package com.jcodee.mod2class3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.mod2class3.R;
import com.jcodee.mod2class3.database.SentenciaSQL;
import com.jcodee.mod2class3.entidade.DetalleTienda;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 13/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DetalleAdapter extends BaseAdapter {
    private Context context;
    private RealmResults<DetalleTienda> lista;

    public DetalleAdapter(Context context, RealmResults<DetalleTienda> lista) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_listado, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        DetalleTienda detalleTienda = (DetalleTienda) getItem(position);

        viewHolder.tvNombre.setText(detalleTienda.getNombre());
        viewHolder.tvCapacidad.setText(String.valueOf(detalleTienda.getCapacidad()));

        SentenciaSQL sentenciaSQL = new SentenciaSQL();
        viewHolder.tvTienda.setText(
                sentenciaSQL.obtenerTiendasPorCodigo(
                        detalleTienda.getIdTienda()).getDescripcion()
        );

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tvTienda)
        TextView tvTienda;
        @BindView(R.id.tvNombre)
        TextView tvNombre;
        @BindView(R.id.tvCapacidad)
        TextView tvCapacidad;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
