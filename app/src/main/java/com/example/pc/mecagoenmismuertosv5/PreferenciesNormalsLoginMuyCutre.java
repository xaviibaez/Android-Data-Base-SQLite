package com.example.pc.mecagoenmismuertosv5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Pc on 22/01/2018.
 */

public class PreferenciesNormalsLoginMuyCutre extends AppCompatActivity{

    EditText campUser, campPass;
    TextView txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencies_cutre);

        campUser = (EditText) findViewById(R.id.campUser);
        campPass = (EditText) findViewById(R.id.campPass);

        txtUser = (TextView) findViewById(R.id.txtUser);
        txtPass = (TextView) findViewById(R.id.txtPass);

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
            case R.id.btnGuardar:
                guardarPrefencies();
                break;
            case R.id.btnCarregar:
                //miIntent = new Intent(ConsultaPreferenciesCutre.this, PreferenciesIdioma.class);
                carregarPreferencies();
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }

    private void carregarPreferencies(){
        SharedPreferences preferences = getSharedPreferences("credencials", Context.MODE_PRIVATE);

        String user = preferences.getString("user","No existeix");
        String pass = preferences.getString("pass","No existeix");

        txtUser.setText(user);
        txtPass.setText(pass);
    }
    private void guardarPrefencies(){

        SharedPreferences preferences = getSharedPreferences("credencials", Context.MODE_PRIVATE);

        String user = campUser.getText().toString();
        String pass = campPass.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", user);
        editor.putString("pass", pass);

        editor.commit();

        campUser.setText("");
        campPass.setText("");
    }

}
