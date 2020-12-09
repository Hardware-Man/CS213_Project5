package com.example.cs213_project5;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

/**
 * Class to run the third activity of Android Museum app:
 * Clicking on museum image to go to museum website
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class ThirdActivity extends AppCompatActivity {

    private WebView webView;

    /**
     * Initializes environment to allow museum image to lead to museum website
     * @param savedInstanceState bundle for current screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        webView = findViewById(R.id.webview);
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

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    /**
     * Goes to the previous screen(second activity)
     */
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}