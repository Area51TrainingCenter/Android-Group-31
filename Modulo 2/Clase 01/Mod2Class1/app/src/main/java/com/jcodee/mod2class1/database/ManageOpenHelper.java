package com.jcodee.mod2class1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by johannfjs on 6/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class ManageOpenHelper extends SQLiteOpenHelper {
    public static final String EMPTY = "";

    public ManageOpenHelper(Context context) {
        //1 = versión 1 de nuestra base de datos
        super(context, "mod2class1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_datos (id integer primary key autoincrement, texto_uno varchar(100), texto_dos varchar(100))");
        db.execSQL("insert into tb_datos (texto_uno, texto_dos) values('Presentación', 'Mockups')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == 2) {
            //Sentencias a realizar
        }
    }
}
