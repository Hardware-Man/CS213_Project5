package com.example.cs213_project5;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    protected static String selectedMuseum = "met";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button metSelect = findViewById(R.id.met_select);
        Button naturalHistorySelect = findViewById(R.id.natural_history_select);
        Button guggenheimSelect = findViewById(R.id.guggenheim_select);
        Button modernArtSelect = findViewById(R.id.modern_art_select);

        metSelect.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
            selectedMuseum = "met";
        });
        naturalHistorySelect.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
            selectedMuseum = "natural";
        });
        guggenheimSelect.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
            selectedMuseum = "guggenheim";
        });
        modernArtSelect.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
            selectedMuseum = "modern";
        });
    }
}