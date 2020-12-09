package com.example.cs213_project5;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button metSelect = findViewById(R.id.met_select);
        Button naturalHistorySelect = findViewById(R.id.natural_history_select);
        Button guggenheimSelect = findViewById(R.id.guggenheim_select);
        Button modernArtSelect = findViewById(R.id.modern_art_select);

        metSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
        naturalHistorySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
        guggenheimSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
        modernArtSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }
        });
    }

    private void launchActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}