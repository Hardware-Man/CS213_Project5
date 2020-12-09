package com.example.cs213_project5;

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
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        switch (MainActivity.selectedMuseum) {
            case "met":
                setTitle("Metropolitan Museum of Art Website");
                webView.loadUrl("https://www.metmuseum.org/");
                break;
            case "natural":
                setTitle("American Museum of Natural History Website");
                webView.loadUrl("https://www.amnh.org/");
                break;
            case "guggenheim":
                setTitle("Solomon R. Guggenheim Museum Website");
                webView.loadUrl("https://www.guggenheim.org/");
                break;
            default:
                setTitle("Museum of Modern Art Website");
                webView.loadUrl("https://www.moma.org/");
        }
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