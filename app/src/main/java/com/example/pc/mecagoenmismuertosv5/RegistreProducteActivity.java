package com.example.pc.mecagoenmismuertosv5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.example.pc.mecagoenmismuertosv5.entitats.Usuari;
import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

import java.util.ArrayList;

/**
 * Created by Pc on 11/01/2018.
 */

public class RegistreProducteActivity extends AppCompatActivity {
    EditText campNomProducte, campQuantitat;
    Spinner comboComprador;

    ArrayList<String> llistaPersonas;
    ArrayList<Usuari> usuarisList;

    ConexioSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_producte);

        campNomProducte = (EditText) findViewById(R.id.campNomProducte);
        campQuantitat = (EditText) findViewById(R.id.campQuantitat);
        comboComprador = (Spinner) findViewById(R.id.comboComprador);

        con = new ConexioSQLiteHelper(getApplicationContext(),"bd_usuaris",null,1);

        consultarListaPersonas();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item, llistaPersonas);

        comboComprador.setAdapter(adaptador);

        comboComprador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
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

    private void registrarProducte() {

        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilitats.NOM_PRODUCTE,campNomProducte.getText().toString());
        values.put(Utilitats.QUANTITAT_PRODUCTE,campQuantitat.getText().toString());

        int idCombo = (int) comboComprador.getSelectedItemId();

        if (idCombo != 0){
            Log.i("MIDA", usuarisList.size() + "");
            Log.i("id combo",idCombo + "");
            Log.i("id combo - 1",(idCombo-1) + "");//-1 perque es vol obteir la posició de llista no del combo
            int idComprador = usuarisList.get(idCombo-1).getId_usuari();
            Log.i("id COMPRADOR",idComprador + "");

            values.put(Utilitats.ID_COMPRADOR,idComprador);

            Long idResultant = db.insert(Utilitats.TAULA_PRODUCTE, Utilitats.ID_PRODUCTE, values);

            Toast.makeText(getApplicationContext(),"ID Registre: " + idResultant,Toast.LENGTH_SHORT).show();
            db.close();
            netejar();
        }
        else{
            Toast.makeText(getApplicationContext(),"Selecciona a un comprador", Toast.LENGTH_LONG).show();
        }
    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = con.getReadableDatabase();

        Usuari persona = null;
        usuarisList = new ArrayList<Usuari>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilitats.TAULA_USUARI,null);

        while (cursor.moveToNext()){
            persona = new Usuari();
            persona.setId_usuari(cursor.getInt(0));
            persona.setNom(cursor.getString(1));
            persona.setCognom(cursor.getString(2));
            persona.setTelefon(cursor.getString(3));

            Log.i("ID",String.valueOf(persona.getId_usuari()));
            Log.i("Nom",persona.getNom());
            Log.i("Cognom",persona.getCognom());
            Log.i("Telefon",persona.getTelefon());

            usuarisList.add(persona);
        }
        obtenirLlista();
    }

    private void netejar() {
        campNomProducte.setText("");
        campQuantitat.setText("");
    }

    private void obtenirLlista() {
        llistaPersonas = new ArrayList<String>();
        llistaPersonas.add("Selecciona");

        for(int i = 0; i< usuarisList.size(); i++){
            llistaPersonas.add(usuarisList.get(i).getId_usuari() + " - " + usuarisList.get(i).getNom());
        }

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistreProducte: registrarProducte();
        }
    }

}
