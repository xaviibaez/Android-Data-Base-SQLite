package com.example.pc.mecagoenmismuertosv5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

import com.example.pc.mecagoenmismuertosv5.entitats.Producte;
import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

import java.util.ArrayList;

/**
 * Created by Pc on 13/01/2018.
 */

public class ConsultaProducte extends AppCompatActivity {

    ListView listViewProducte;
    ArrayList<String> llistaInformacio;
    ArrayList<Producte> llistaProductes;

    ConexioSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_producte);

        con = new ConexioSQLiteHelper(getApplicationContext(),"bd_usuaris",null,1);

        listViewProducte = (ListView) findViewById(R.id.listViewProductes);

        consultarLlistaUsuaris();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1, llistaInformacio);
        listViewProducte.setAdapter(adaptador);

        listViewProducte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Producte producte = llistaProductes.get(pos);

                Intent intent = new Intent(ConsultaProducte.this, DetallProducte.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("producte", producte);


                Producte kk = (Producte) bundle.getSerializable("producte");

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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

        Producte producte = null;
        llistaProductes = new ArrayList<Producte>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilitats.TAULA_PRODUCTE,null);

        while (cursor.moveToNext()){
            producte = new Producte();
            producte.setId_producte(cursor.getInt(0));
            producte.setNom_producte(cursor.getString(1));
            producte.setQuantitat(cursor.getInt(2));
            producte.setId_comprador(cursor.getInt(3));

            llistaProductes.add(producte);
        }
        obtenirLlista();
    }

    private void obtenirLlista() {
        llistaInformacio = new ArrayList<String>();

        for (int i = 0; i < llistaProductes.size(); i++){
            llistaInformacio.add(/*llistaProductes.get(i).getId_producte()
                    + " - " + */llistaProductes.get(i).getNom_producte()
                    + " - " + llistaProductes.get(i).getQuantitat()
                    + " - " + llistaProductes.get(i).getId_comprador()
            );
        }

    }
}
