package com.example.pc.mecagoenmismuertosv5;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
/**
 * Created by Pc on 21/01/2018.
 */

public class IdiomaSegundari extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }

}
