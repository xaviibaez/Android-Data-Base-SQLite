package com.example.pc.mecagoenmismuertosv5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexioSQLiteHelper con = new ConexioSQLiteHelper(this,"bd_usuaris",null,1);

        setToolbar();// Añadir action bar
        /*if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnRegistreUsuari:
                miIntent = new Intent(MainActivity.this,RegistreUsuariActivity.class);
                break;
            case R.id.btnRegistreProducte:
                miIntent = new Intent(MainActivity.this,RegistreProducteActivity.class);
                break;
            case R.id.btnConsultarUsuari:
                miIntent = new Intent(MainActivity.this,OpcionsConsultaUsuari.class);
                break;
            case R.id.btnConsultarProducte:
                miIntent = new Intent(MainActivity.this,OpcionsConsultaProducte.class);
                break;
            case R.id.btnPreferencies:
                miIntent = new Intent(MainActivity.this,OpcionsPreferencies.class);
                break;

        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
}
