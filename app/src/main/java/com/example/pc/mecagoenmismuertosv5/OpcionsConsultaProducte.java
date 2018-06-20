package com.example.pc.mecagoenmismuertosv5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.widget.Toolbar;

/**
 * Created by Pc on 18/01/2018.
 */

public class OpcionsConsultaProducte extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcions_consulta_producte);

        ConexioSQLiteHelper con = new ConexioSQLiteHelper(this,"bd_usuaris",null,1);

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
        Intent miIntent = null;
        switch (view.getId()){
            case R.id.btnConsultaNormal:
                miIntent = new Intent(OpcionsConsultaProducte.this, ConsultaProducteOpcions.class);
                break;
            case R.id.btnConsultaRecycler:
                miIntent = new Intent(OpcionsConsultaProducte.this, ConsultaProducte.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}
