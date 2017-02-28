package com.jcodee.clase04.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jcodee.clase04.DatosActivity;
import com.jcodee.clase04.fragments.DetalleFragment;

/**
 * Created by johannfjs on 27/02/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class DetalleAdapter extends FragmentStatePagerAdapter {
    public DetalleAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //Creamos un objeto de tipo fragmento
        DetalleFragment detalleFragment = new DetalleFragment();
        //Creamos un bundle, en el cual se le pasará los datos
        Bundle bundle = new Bundle();
        //Cargamos un dato de tipo entero
        bundle.putInt("posicion", position);
        //Guardamos las variables que vamos a pasar al fragmento
        detalleFragment.setArguments(bundle);
        //Retornamos el fragmento
        return detalleFragment;
    }

    @Override
    public int getCount() {
        return DatosActivity.lista.size();
    }

    //Creamos una paginacion de los fragmentos que estamos creando los cuales mantienen
    //su estado
}
