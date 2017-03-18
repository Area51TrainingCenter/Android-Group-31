package com.jcodee.mod2class4.database;

import com.jcodee.mod2class4.entidades.DatosEntidad;
import com.jcodee.mod2class4.modelos.Datos;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 15/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SentenciaSQL {
    //Obtener el siguiente Id
    public static int nextIdDatos() {
        Realm realm = Realm.getDefaultInstance();
        long valor = realm.where(DatosEntidad.class).count();
        return (int) valor+1;
    }

    public static void registrarDatos(DatosEntidad datosEntidad) {
        Realm realm = Realm.getDefaultInstance();

        try {
            realm.beginTransaction();

            realm.copyToRealm(datosEntidad);

            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    public static RealmResults<DatosEntidad> obtenerDatos(String titulo) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(DatosEntidad.class).contains("titulo", titulo).findAll();
    }
}
