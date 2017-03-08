package com.jcodee.mod2class1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jcodee.mod2class1.modelos.Datos;

import java.util.ArrayList;

/**
 * Created by johannfjs on 6/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

/*
  Formas de consumo de Web Services
  HttpRequest
  Volley
  Retrofit
  OkHttp
 */

public class SentenciaSQL {
    private ManageOpenHelper conexion;

    public SentenciaSQL(Context context) {
        //Iniciamos la conexión a la bd
        conexion = new ManageOpenHelper(context);
    }

    public void registrar(String textoUno, String textoDos) {
        //Asignamos el permiso de escritura a la base de datos
        SQLiteDatabase db = conexion.getWritableDatabase();
        //Creamos las variables con los parametros que vamos a registrar
        ContentValues contentValues = new ContentValues();
        //Agregamos los datos que se van a guardar
        contentValues.put("texto_uno", textoUno);
        contentValues.put("texto_dos", textoDos);
        //Registrar los datos a nuestra base de datos
        db.insert("tb_datos", null, contentValues);
    }

    public void actualizar(String textUno, String textoDos, int id) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //Validamos que traiga algún dato
        if (!textUno.equals("")) {
            contentValues.put("texto_uno", textUno);
        }
        if (!textoDos.equals("")) {
            contentValues.put("texto_dos", textoDos);
        }
        db.update("tb_datos", contentValues, "id=" + id, null);
    }

    public void eliminar(int id) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        db.delete("tb_datos", "id=" + id, null);
    }

    public ArrayList<Datos> obtener() {
        //asignamos permiso de solo lectura
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Creamos nuestra sentencia SQL
        Cursor cursor = db.rawQuery("select * from tb_datos", null);
        //Creamos una lista de tipo Datos
        ArrayList<Datos> lista = new ArrayList<>();
        //Ejecutamos para verificar si es que hay registros
        if (cursor.moveToFirst()) {
            do {
                //Creamos un objeto donde se almacenaran los datos
                Datos datos = new Datos();
                //Setteamos todos los datos
                datos.setId(cursor.getInt(cursor.getColumnIndex("id")));
                datos.setTextoUno(cursor.getString(cursor.getColumnIndex("texto_uno")));
                datos.setTextoUno(cursor.getString(cursor.getColumnIndex("texto_dos")));
                //Añadimos los datos a la lista
                lista.add(datos);
                //Recorre el bucle siempre y cuando haya registros
            } while (cursor.moveToNext());
        }
        return lista;
    }
}
