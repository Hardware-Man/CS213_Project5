package com.example.cs213_project5;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Toast.makeText(getApplicationContext(),"Maximum of 5 tickets for each!",Toast.LENGTH_SHORT).show();

        ImageView museumPicture = findViewById(R.id.museumSelection);
        switch (MainActivity.selectedMuseum) {
            case "met":
                museumPicture.setImageResource(R.drawable.met);
                break;
            case "natural":
                museumPicture.setImageResource(R.drawable.natural_history);
                break;
            case "guggenheim":
                museumPicture.setImageResource(R.drawable.guggenheim);
                break;
            default:
                museumPicture.setImageResource(R.drawable.modern_art);
        }
        museumPicture.setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
    }
}