package com.cdp.rememberme.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper{

    Context context;
    public DbContactos(@Nullable Context context) {
        super(context);
        this.context =context;
    }

    public long insertarContactos(String titulo, String direccion, String descripcion){
        long id=0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            //insertar registro a la table
            ContentValues values = new ContentValues();
            //insertar cada columna
            values.put("titulo", titulo);
            values.put("direccion", direccion);
            values.put("descripcion", descripcion);

            //regresa el id insertado
            id = db.insert(TABLE_CONTACTOS, null, values);

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
