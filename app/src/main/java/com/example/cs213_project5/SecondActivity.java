package com.example.cs213_project5;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
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

        TextView adultTicketPrice = findViewById(R.id.adultTicket);
        TextView seniorTicketPrice = findViewById(R.id.seniorTicket);
        TextView studentTicketPrice = findViewById(R.id.studentTicket);

        switch (MainActivity.selectedMuseum) {
            case "met":
                museumPicture.setImageResource(R.drawable.met);
                adultTicketPrice.setText(adultTicketPrice.getText() + " $25");
                seniorTicketPrice.setText(seniorTicketPrice.getText() + " $17");
                studentTicketPrice.setText(studentTicketPrice.getText() + " $12");
                break;
            case "natural":
                museumPicture.setImageResource(R.drawable.natural_history);
                adultTicketPrice.setText(adultTicketPrice.getText() + " $23");
                seniorTicketPrice.setText(seniorTicketPrice.getText() + " $18");
                studentTicketPrice.setText(studentTicketPrice.getText() + " $18");
                break;
            case "guggenheim":
                museumPicture.setImageResource(R.drawable.guggenheim);
                adultTicketPrice.setText(adultTicketPrice.getText() + " $25");
                seniorTicketPrice.setText(seniorTicketPrice.getText() + " $18");
                studentTicketPrice.setText(studentTicketPrice.getText() + " $18");
                break;
            default:
                museumPicture.setImageResource(R.drawable.modern_art);
                adultTicketPrice.setText(adultTicketPrice.getText() + " $25");
                seniorTicketPrice.setText(seniorTicketPrice.getText() + " $14");
                studentTicketPrice.setText(studentTicketPrice.getText() + " $18");
        }
        museumPicture.setOnClickListener(v -> startActivity(new Intent(this, ThirdActivity.class)));
    }
}