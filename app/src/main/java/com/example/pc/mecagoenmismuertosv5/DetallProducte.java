package com.example.pc.mecagoenmismuertosv5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.example.pc.mecagoenmismuertosv5.entitats.Producte;
import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

/**
 * Created by Pc on 13/01/2018.
 */

public class DetallProducte extends AppCompatActivity {

    ConexioSQLiteHelper con;
    TextView campIdProducte, campNomProducte, campQuantitat;
    TextView campIdUsuari, campNomUsuari, campCognomUsuari, campTelefonUsuari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall_producte);

        con = new ConexioSQLiteHelper(getApplicationContext(),"bd_usuaris",null,1);

        campIdUsuari = (TextView) findViewById(R.id.campIdUsuari);
        campNomUsuari = (TextView) findViewById(R.id.campNom);
        campCognomUsuari = (TextView) findViewById(R.id.campCognom);
        campTelefonUsuari = (TextView) findViewById(R.id.campTelefon);

        campIdProducte = (TextView) findViewById(R.id.campIdProducte);
        campNomProducte = (TextView) findViewById(R.id.campNomProducte);
        campQuantitat = (TextView) findViewById(R.id.campQuantitat);

        Bundle producteEnviat = getIntent().getExtras();
        Producte producte = null;

        if(producteEnviat!=null){
            producte= (Producte) producteEnviat.getSerializable("producte");

            campIdProducte.setText(String.valueOf(producte.getId_producte()));
            campNomProducte.setText(producte.getNom_producte().toString());
            campQuantitat.setText(String.valueOf(producte.getQuantitat()));
            consultarPersona(producte.getId_comprador());
        }

        setToolbar();// Añadir action bar
        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void consultarPersona(Integer idPersona) {
        SQLiteDatabase db = con.getReadableDatabase();

        try {
            String superConsulta =  "SELECT "
                    + Utilitats.ID_USUARI + ", "
                    + Utilitats.NOM_USUARI + ", "
                    + Utilitats.COGNOM_USUARI + ", "
                    + Utilitats.TELEFON_USUARI
                    + " FROM " + Utilitats.TAULA_USUARI
                    + " WHERE " + Utilitats.ID_USUARI + " = " + idPersona.toString();

            Cursor c = db.rawQuery(superConsulta, null);

            if(c != null){
                c.moveToFirst();
            }

            campIdUsuari.setText(c.getString(0));
            campNomUsuari.setText(c.getString(1));
            campCognomUsuari.setText(c.getString(2));
            campTelefonUsuari.setText(c.getString(3));

            c.close();
            db.close();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"El document no existeix", Toast.LENGTH_LONG).show();
            campIdUsuari.setText("");
            campNomUsuari.setText("");
            campCognomUsuari.setText("");
            campTelefonUsuari.setText("");
        }
    }
}
