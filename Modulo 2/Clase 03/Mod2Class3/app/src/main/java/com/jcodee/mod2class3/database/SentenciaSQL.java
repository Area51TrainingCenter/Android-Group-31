package com.jcodee.mod2class3.database;

import com.jcodee.mod2class3.entidade.DetalleTienda;
import com.jcodee.mod2class3.entidade.Tiendas;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johannfjs on 10/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class SentenciaSQL {
    public int nextIdTienda() {
        Realm realm = Realm.getDefaultInstance();
        long cantidad = realm.where(Tiendas.class).count();
        return ((int) cantidad) + 1;
    }

    public int nextIdDetalleTienda() {
        //Obtenemos la inicialización de la base de datos
        Realm realm = Realm.getDefaultInstance();
        //Obtenemos la cantidad de elementos que están registrados en la bd
        long cantidad = realm.where(DetalleTienda.class).count();
        //Obtenemos el siguiente id
        return ((int) cantidad) + 1;
    }

    public void registrarTienda(Tiendas tiendas) {
        //Obtenemos la inicialización de la base de datos
        Realm realm = Realm.getDefaultInstance();
        try {
            //Creamos una transacción
            realm.beginTransaction();
            //Registramos en la base de datos
            realm.copyToRealm(tiendas);
            //Guardamos los cambios en la base de datos
            realm.commitTransaction();
        } catch (Exception e) {
            //En caso se cae, se cancela la transacción
            realm.cancelTransaction();
        }
    }

    public void registrarDetalleTienda(DetalleTienda detalleTienda) {
        //Obtenemos la inicialización de la base de datos
        Realm realm = Realm.getDefaultInstance();
        try {
            //Creamos una transacción
            realm.beginTransaction();
            //Registramos en la base de datos
            realm.copyToRealm(detalleTienda);
            //Guardamos los cambios en la base de datos
            realm.commitTransaction();
        } catch (Exception e) {
            //En caso se cae, se cancela la transacción
            realm.cancelTransaction();
        }
    }

    public RealmResults<Tiendas> obtenerTiendas() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Tiendas.class).findAll();
    }

    public RealmResults<DetalleTienda> obtenerDetalleTiendas() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(DetalleTienda.class).findAll();
    }
}
