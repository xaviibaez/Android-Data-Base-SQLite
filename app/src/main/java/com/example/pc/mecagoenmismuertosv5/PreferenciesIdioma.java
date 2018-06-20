package com.example.pc.mecagoenmismuertosv5;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Pc on 21/01/2018.
 */

public class PreferenciesIdioma extends AppCompatActivity {

    TextView mTitleTextView;
    TextView mDescTextView;
    TextView mAboutTextView;

    Button mToCATButton;
    Button mToENButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencies_idioma);

        mTitleTextView = (TextView)findViewById(R.id.titleTextView);
        mDescTextView = (TextView)findViewById(R.id.descTextView);
        mAboutTextView = (TextView)findViewById(R.id.aboutTextView);

        mToCATButton = (Button) findViewById(R.id.toCATButton);
        mToENButton = (Button)findViewById(R.id.toENButton);

        mToCATButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews("default");
            }
        });

        mToENButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews("en");
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }

    private void updateViews(String languageCode) {
        Context context = LocaleHelper.setLocale(this, languageCode);
        Resources resources = context.getResources();
/*
    // Change locale settings in the app.
        DisplayMetrics dm = resources.getDisplayMetrics();
        android.content.resources.Configuration conf = resources.getConfiguration();
        conf.setLocale(new Locale(language_code.toLowerCase())); // API 17+ only.
    // Use conf.locale = new Locale(...) if targeting lower versions
        resources.updateConfiguration(conf, dm);*/
    }
}
