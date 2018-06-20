package com.example.pc.mecagoenmismuertosv5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

/**
 * Created by Pc on 13/01/2018.
 */

public class ConsultaUsuari extends AppCompatActivity {

    EditText documentID,campNomConsulta, campCognomConsulta, campTelefonConsulta;
    ConexioSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_usuari);

        con = new ConexioSQLiteHelper(getApplicationContext(),"bd_usuaris",null,1);

        documentID = (EditText) findViewById(R.id.documentID);
        campNomConsulta = (EditText) findViewById(R.id.campNomConsulta);
        campCognomConsulta = (EditText) findViewById(R.id.campCognomConsulta);
        campTelefonConsulta = (EditText) findViewById(R.id.campTelefonConsulta);


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

        switch (view.getId()){
            case R.id.btnConsultar:
                consultarUsuari();
                break;
            case R.id.btnActualitzar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarUsuario();
                break;
        }

    }

    private void eliminarUsuario() {
        SQLiteDatabase db = con.getWritableDatabase();

        String[] parametres = {documentID.getText().toString()};

        db.delete(Utilitats.TAULA_USUARI,Utilitats.ID_USUARI + "=?", parametres);

        Toast.makeText(getApplicationContext(),"Usuari eliminat", Toast.LENGTH_LONG).show();

        documentID.setText("");
        netejar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db = con.getWritableDatabase();
        String[] parametres = {documentID.getText().toString()};
        ContentValues values = new ContentValues();

        values.put(Utilitats.NOM_USUARI,campNomConsulta.getText().toString());
        values.put(Utilitats.COGNOM_USUARI,campCognomConsulta.getText().toString());
        values.put(Utilitats.TELEFON_USUARI,campTelefonConsulta.getText().toString());

        db.update(Utilitats.TAULA_USUARI, values,Utilitats.ID_USUARI + "=?", parametres);
        Toast.makeText(getApplicationContext(),"Usuari actualitzat",Toast.LENGTH_LONG).show();
        netejar();
        db.close();

    }

    private void consultarUsuari() {
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametres = {documentID.getText().toString()};

        try {
            Cursor cursor = db.rawQuery("SELECT " + Utilitats.NOM_USUARI + "," + Utilitats.COGNOM_USUARI + "," + Utilitats.TELEFON_USUARI +
                    " FROM " + Utilitats.TAULA_USUARI + " WHERE " + Utilitats.ID_USUARI + "=?", parametres);

            cursor.moveToFirst();
            campNomConsulta.setText(cursor.getString(0));
            campCognomConsulta.setText(cursor.getString(1));
            campTelefonConsulta.setText(cursor.getString(2));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El document no existeix",Toast.LENGTH_LONG).show();
            netejar();
        }

    }

    private void netejar() {
        campNomConsulta.setText("");
        campCognomConsulta.setText("");
        campTelefonConsulta.setText("");
    }

}
