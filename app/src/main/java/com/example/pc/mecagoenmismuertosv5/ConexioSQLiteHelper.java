package com.example.pc.mecagoenmismuertosv5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

/**
 * Created by Pc on 11/01/2018.
 */

public class ConexioSQLiteHelper extends SQLiteOpenHelper {
    public ConexioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilitats.CREAR_TAULA_USUARI);
        db.execSQL(Utilitats.CREAR_TAULA_PRODUCTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versioAntiga, int versioNova) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilitats.TAULA_USUARI);
        db.execSQL("DROP TABLE IF EXISTS " + Utilitats.TAULA_PRODUCTE);
        onCreate(db);
    }

}
