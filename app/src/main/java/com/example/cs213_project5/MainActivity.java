package com.example.cs213_project5;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/**
 * Class to run the main activity of Android Museum app:
 * Clicking on museum image to go to museum second activity tab
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class MainActivity extends AppCompatActivity {

    protected static String selectedMuseum = "met";

    /**
     * Initializes environment for selection stage for moving onto next activity
     * @param savedInstanceState Bundle for the current screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("NYC Museums");

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