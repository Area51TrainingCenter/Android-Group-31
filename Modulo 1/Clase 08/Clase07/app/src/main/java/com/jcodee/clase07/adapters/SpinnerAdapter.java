package com.jcodee.clase07.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jcodee.clase07.R;
import com.jcodee.clase07.views.TextViewCustom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 3/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SpinnerAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> lista;

    public SpinnerAdapter(@NonNull Context context, @NonNull ArrayList<String> objects) {
        super(context, R.layout.item_spinner_custom_dropdown, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder {
        TextViewCustom tvTexto;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_spinner_custom_dropdown, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvTexto = (TextViewCustom) convertView.findViewById(R.id.tvTexto);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.tvTexto.setText(lista.get(position));
        return convertView;
    }
}
