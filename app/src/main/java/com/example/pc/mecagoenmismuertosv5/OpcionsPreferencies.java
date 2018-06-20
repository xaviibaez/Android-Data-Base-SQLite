package com.example.pc.mecagoenmismuertosv5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Pc on 21/01/2018.
 */

public class OpcionsPreferencies extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcions_preferencies);


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
            case R.id.btnColors:
                miIntent = new Intent(OpcionsPreferencies.this, PreferenciesColors.class);
                break;
            case R.id.btnIdioma:
                miIntent = new Intent(OpcionsPreferencies.this, PreferenciesIdioma.class);
                break;
            case R.id.btnPreferenciesNormals:
                miIntent = new Intent(OpcionsPreferencies.this, PreferenciesNormalsLoginMuyCutre.class);
                break;
            case R.id.btnCopy:
                miIntent = new Intent(OpcionsPreferencies.this, PreferenciesCopy.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}
