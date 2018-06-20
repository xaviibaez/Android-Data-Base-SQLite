package com.example.pc.mecagoenmismuertosv5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.pc.mecagoenmismuertosv5.adaptadors.LlistaUsuarisAdapter;
import com.example.pc.mecagoenmismuertosv5.entitats.Usuari;
import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

import java.util.ArrayList;

/**
 * Created by Pc on 16/01/2018.
 */

public class ConsultaUsuariRecycler extends AppCompatActivity {

    ArrayList<Usuari> llistaUsuaris;
    RecyclerView recyclerViewUsuaris;

    ConexioSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_usuari_recycler);

        con = new ConexioSQLiteHelper(getApplicationContext(),"bd_usuaris",null,1);

        llistaUsuaris = new ArrayList<>();

        recyclerViewUsuaris = (RecyclerView) findViewById(R.id.recyclerUsuaris);
        recyclerViewUsuaris.setLayoutManager(new LinearLayoutManager(this));

        consultarLlistaUsuaris();

        LlistaUsuarisAdapter adapter = new LlistaUsuarisAdapter(llistaUsuaris);
        recyclerViewUsuaris.setAdapter(adapter);

        setToolbar();// Añadir action bar
        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void consultarLlistaUsuaris() {
        SQLiteDatabase db = con.getReadableDatabase();

        Usuari usuari = null;
        // listaUsuarios=new ArrayList<Usuario>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilitats.TAULA_USUARI,null);

        while (cursor.moveToNext()){
            usuari = new Usuari();
            usuari.setId_usuari(cursor.getInt(0));
            usuari.setNom(cursor.getString(1));
            usuari.setCognom(cursor.getString(2));
            usuari.setTelefon(cursor.getString(3));

            llistaUsuaris.add(usuari);
        }
    }
}
