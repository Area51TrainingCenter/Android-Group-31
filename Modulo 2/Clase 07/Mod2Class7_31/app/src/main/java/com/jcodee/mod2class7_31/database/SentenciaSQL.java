package com.jcodee.mod2class7_31.database;

import com.jcodee.mod2class7_31.entidades.Ubicaciones;

import io.realm.Realm;

/**
 * Created by johannfjs on 20/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SentenciaSQL {
    public static int nextId() {
        Realm realm = Realm.getDefaultInstance();
        long cantidad = realm.where(Ubicaciones.class).count();
        return (int) cantidad + 1;
    }

    public static void registrar(Ubicaciones ubicaciones) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            realm.copyToRealm(ubicaciones);

            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }
}
