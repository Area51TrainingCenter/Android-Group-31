package com.jcodee.clase04.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.clase04.DatosActivity;
import com.jcodee.clase04.R;
import com.jcodee.clase04.modelos.Galeria;

/**
 * Created by johannfjs on 27/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DetalleFragment extends Fragment {
    private SimpleDraweeView sdvImagen;
    private TextView tvTexto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView = LayoutInflater.from(getActivity())
                .inflate(R.layout.fragment_detalle,
                        container,
                        false);

        sdvImagen = (SimpleDraweeView) convertView.findViewById(R.id.sdvImage);
        tvTexto = (TextView) convertView.findViewById(R.id.tvTexto);

        //Verificamos que se esté enviando información a través del bundle
        if (getArguments() != null) {
            //Verificamos si el valor o key posicion se ha enviado a través del bundle
            if (getArguments().containsKey("posicion")) {
                //Obtenemos el dato de posicion
                int posicion = getArguments().getInt("posicion");

                //Obtenemos el objeto que a través de la posición que hemos obtenido
                Galeria galeria = DatosActivity.lista.get(posicion);

                //Setteamos los datos de los componentes para poder mostrarlo
                tvTexto.setText(galeria.getNombre());
                sdvImagen.setImageURI(Uri.parse(galeria.getRutaImagen()));
            }
        }

        return convertView;
    }
}
