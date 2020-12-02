package com.integrator.giti.reminders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class InformacionActivity extends AppCompatActivity {

    WebView vwBuscador;

    String url = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        vwBuscador = (WebView) findViewById(R.id.vwBuscador);
        final WebSettings ajustesVisorWeb = vwBuscador.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        vwBuscador.loadUrl(url);
    }

    //Impedir que el botón Atrás cierre la aplicación
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView vwBuscador;
        vwBuscador = (WebView) findViewById(R.id.vwBuscador);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (vwBuscador.canGoBack()) {
                        vwBuscador.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}