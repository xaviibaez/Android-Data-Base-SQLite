package com.example.pc.mecagoenmismuertosv5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.mecagoenmismuertosv5.utilitats.Utilitats;

/**
 * Created by Pc on 18/01/2018.
 */

public class ConsultaProducteOpcions extends AppCompatActivity {

    EditText documentID,campNomConsulta, campQuantitat;
    ConexioSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_producte_eliminar_editar);

        con = new ConexioSQLiteHelper(getApplicationContext(),"bd_usuaris",null,1);

        documentID = (EditText) findViewById(R.id.documentID);
        campNomConsulta = (EditText) findViewById(R.id.campNomConsulta);
        campQuantitat = (EditText) findViewById(R.id.campQuantitat);

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

        db.delete(Utilitats.TAULA_PRODUCTE,Utilitats.ID_PRODUCTE + "=?", parametres);

        Toast.makeText(getApplicationContext(),"Producte eliminat", Toast.LENGTH_LONG).show();

        documentID.setText("");
        netejar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db = con.getWritableDatabase();
        String[] parametres = {documentID.getText().toString()};
        ContentValues values = new ContentValues();

        values.put(Utilitats.NOM_PRODUCTE,campNomConsulta.getText().toString());
        values.put(Utilitats.QUANTITAT_PRODUCTE,campQuantitat.getText().toString());

        db.update(Utilitats.TAULA_PRODUCTE, values,Utilitats.ID_PRODUCTE + "=?", parametres);
        Toast.makeText(getApplicationContext(),"Producte actualitzat",Toast.LENGTH_LONG).show();
        netejar();
        db.close();
    }

    private void consultarUsuari() {
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametres = {documentID.getText().toString()};

        try {
            Cursor cursor = db.rawQuery("SELECT " + Utilitats.NOM_PRODUCTE + "," + Utilitats.QUANTITAT_PRODUCTE  +
                    " FROM " + Utilitats.TAULA_PRODUCTE + " WHERE " + Utilitats.ID_PRODUCTE + "=?", parametres);

            cursor.moveToFirst();
            campNomConsulta.setText(cursor.getString(0));
            campQuantitat.setText(cursor.getString(1));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El document no existeix", Toast.LENGTH_LONG).show();
            netejar();
        }

    }

    private void netejar() {
        campNomConsulta.setText("");
        campQuantitat.setText("");
    }

}
