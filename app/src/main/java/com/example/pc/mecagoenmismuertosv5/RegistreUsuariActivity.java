package com.example.pc.mecagoenmismuertosv5;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

/**
 * Created by Pc on 11/01/2018.
 */

public class RegistreUsuariActivity extends AppCompatActivity {
    EditText campId, campNom, campCognom, campTelefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_usuari);

        campId = (EditText) findViewById(R.id.campIdUsuari);
        campNom = (EditText) findViewById(R.id.campNom);
        campCognom = (EditText) findViewById(R.id.campCognom);
        campTelefon= (EditText) findViewById(R.id.campTelefon);

        setToolbar();// Añadir action bar
        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClick(View view) {
        registrarUsuaris();
    }

    private void registrarUsuaris() {
        ConexioSQLiteHelper con = new ConexioSQLiteHelper(this,"bd_usuaris",null,1);

        SQLiteDatabase db = con.getWritableDatabase();

        String insert = "INSERT INTO " + Utilitats.TAULA_USUARI
                + " ( "
                + Utilitats.ID_USUARI
                + "," +
                Utilitats.NOM_USUARI
                + "," +
                Utilitats.COGNOM_USUARI
                + "," +
                Utilitats.TELEFON_USUARI
                + ")"
                + " VALUES ("
                + campId.getText().toString()
                + ", '"
                + campNom.getText().toString()
                + "','"
                + campCognom.getText().toString()
                + "','"
                + campTelefon.getText().toString()
                + "')";

        Toast.makeText(getApplicationContext(),"Usuari registrat", Toast.LENGTH_LONG).show();
        netejar();

        db.execSQL(insert);
        db.close();
    }

    private void netejar() {
        campId.setText("");
        campNom.setText("");
        campCognom.setText("");
        campTelefon.setText("");
    }
}
