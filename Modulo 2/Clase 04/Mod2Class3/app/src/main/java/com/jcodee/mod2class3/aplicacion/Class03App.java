package com.jcodee.mod2class3.aplicacion;

import android.app.Application;

import com.jcodee.mod2class3.database.SentenciaSQL;
import com.jcodee.mod2class3.entidade.Tiendas;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by johannfjs on 10/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Class03App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .name("class3.realm")
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        Tiendas tiendas = new Tiendas();
                        tiendas.setId(1);
                        tiendas.setDescripcion("Saga");
                        realm.copyToRealm(tiendas);

                        Tiendas tiendas1 = new Tiendas();
                        tiendas1.setId(2);
                        tiendas1.setDescripcion("Ripley");
                        realm.copyToRealm(tiendas1);

                        Tiendas tiendas2 = new Tiendas();
                        tiendas2.setId(3);
                        tiendas2.setDescripcion("Tottus");
                        realm.copyToRealm(tiendas2);

                    }
                })
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
