package ru.pkmpei.mpei_pk.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import ru.pkmpei.mpei_pk.R;

/**
 * Created by infrostorm on 12.11.2017.
 */

public class WebActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);
        webView = findViewById(R.id.webView);
        webView.loadUrl("http://www.pkmpei.ru/");
    }
}
