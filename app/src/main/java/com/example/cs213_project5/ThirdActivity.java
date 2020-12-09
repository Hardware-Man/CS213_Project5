package com.example.cs213_project5;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class ThirdActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        switch (MainActivity.selectedMuseum) {
            case "met":
                webView.loadUrl("https://www.metmuseum.org/");
                break;
            case "natural":
                webView.loadUrl("https://www.amnh.org/");
                break;
            case "guggenheim":
                webView.loadUrl("https://www.guggenheim.org/");
                break;
            default:
                webView.loadUrl("https://www.moma.org/");
        }

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}