package com.example.cs213_project5;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Class to run the second activity of Android Museum app:
 * Based on number of and types of tickets, determine price and tax
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class SecondActivity extends AppCompatActivity {

    private int numAdultTick = 0;
    private int numSeniorTick = 0;
    private int numStudentTick = 0;

    private int adultTickPrice = 0;
    private int seniorTickPrice = 0;
    private int studentTickPrice = 0;

    /**
     * Initializes environment for ticket activity
     * @param savedInstanceState Bundle instance of current screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Toast.makeText(getApplicationContext(),"Maximum of 5 tickets for each!",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Click on image to visit website",Toast.LENGTH_SHORT).show();

        ImageView museumPicture = findViewById(R.id.museumSelection);

        TextView adultTicketPriceText = findViewById(R.id.adultTicket);
        TextView seniorTicketPriceText = findViewById(R.id.seniorTicket);
        TextView studentTicketPriceText = findViewById(R.id.studentTicket);

        switch (MainActivity.selectedMuseum) {
            case "met":
                setTitle("Metropolitan Museum of Art Pricing");
                museumPicture.setImageResource(R.drawable.met);
                adultTicketPriceText.setText(adultTicketPriceText.getText() + " $25");
                adultTickPrice = 25;
                seniorTicketPriceText.setText(seniorTicketPriceText.getText() + " $17");
                seniorTickPrice = 17;
                studentTicketPriceText.setText(studentTicketPriceText.getText() + " $12");
                studentTickPrice = 12;
                break;
            case "natural":
                setTitle("American Museum of Natural History Pricing");
                museumPicture.setImageResource(R.drawable.natural_history);
                adultTicketPriceText.setText(adultTicketPriceText.getText() + " $23");
                adultTickPrice = 23;
                seniorTicketPriceText.setText(seniorTicketPriceText.getText() + " $18");
                seniorTickPrice = 18;
                studentTicketPriceText.setText(studentTicketPriceText.getText() + " $18");
                studentTickPrice = 18;
                break;
            case "guggenheim":
                setTitle("Solomon R. Guggenheim Museum Pricing");
                museumPicture.setImageResource(R.drawable.guggenheim);
                adultTicketPriceText.setText(adultTicketPriceText.getText() + " $25");
                adultTickPrice = 25;
                seniorTicketPriceText.setText(seniorTicketPriceText.getText() + " $18");
                seniorTickPrice = 18;
                studentTicketPriceText.setText(studentTicketPriceText.getText() + " $18");
                studentTickPrice = 18;
                break;
            default:
                setTitle("Museum of Modern Art Pricing");
                museumPicture.setImageResource(R.drawable.modern_art);
                adultTicketPriceText.setText(adultTicketPriceText.getText() + " $25");
                adultTickPrice = 25;
                seniorTicketPriceText.setText(seniorTicketPriceText.getText() + " $18");
                seniorTickPrice = 18;
                studentTicketPriceText.setText(studentTicketPriceText.getText() + " $14");
                studentTickPrice = 14;
        }
        museumPicture.setOnClickListener(v -> startActivity(new Intent(this, ThirdActivity.class)));

        Button addAdult = findViewById(R.id.addAdult);
        Button removeAdult = findViewById(R.id.removeAdult);
        Button addSenior = findViewById(R.id.addSenior);
        Button removeSenior = findViewById(R.id.removeSenior);
        Button addStudent = findViewById(R.id.addStudent);
        Button removeStudent = findViewById(R.id.removeStudent);

        addAdult.setOnClickListener(v -> changeTicketPricing('a',true));
        removeAdult.setOnClickListener(v -> changeTicketPricing('a',false));
        addSenior.setOnClickListener(v -> changeTicketPricing('o',true));
        removeSenior.setOnClickListener(v -> changeTicketPricing('o',false));
        addStudent.setOnClickListener(v -> changeTicketPricing('s',true));
        removeStudent.setOnClickListener(v -> changeTicketPricing('s',false));
    }

    /**
     * Changes the price of tickets based off how many tickets have been chosen
     * Also does not allow for more than 5 tickets to be ordered
     * @param ticketType type of ticket in question
     * @param increase true if ticket amount was increased, false otherwise
     */
    private void changeTicketPricing(char ticketType, boolean increase) {
        switch (ticketType) {
            case 'a':
                if (increase && numAdultTick < 5) {
                    numAdultTick++;
                }
                else if(!increase && numAdultTick > 0) {
                    numAdultTick--;
                }
                TextView adultTicketText = findViewById(R.id.numAdultTickets);
                adultTicketText.setText(adultTicketText.getText().subSequence(0,adultTicketText.getText().length()-1) + Integer.toString(numAdultTick));
                break;
            case 'o':
                if (increase && numSeniorTick < 5) {
                    numSeniorTick++;
                }
                else if(!increase && numSeniorTick > 0) {
                    numSeniorTick--;
                }
                TextView seniorTicketText = findViewById(R.id.numSeniorTickets);
                seniorTicketText.setText(seniorTicketText.getText().subSequence(0,seniorTicketText.getText().length()-1) + Integer.toString(numSeniorTick));
                break;
            default:
                if (increase && numStudentTick < 5) {
                    numStudentTick++;
                }
                else if(!increase && numStudentTick > 0) {
                    numStudentTick--;
                }
                TextView studentTicketText = findViewById(R.id.numStudentTickets);
                studentTicketText.setText(studentTicketText.getText().subSequence(0,studentTicketText.getText().length()-1) + Integer.toString(numStudentTick));
        }

        int ticketPricing = adultTickPrice * numAdultTick + seniorTickPrice * numSeniorTick + studentTickPrice * numStudentTick;
        double salesTaxPrice = 0.08875 * ticketPricing;
        double totalPrice = ticketPricing + salesTaxPrice;

        DecimalFormat moneyFormat = new DecimalFormat("0.00");

        ((TextView)findViewById(R.id.ticketPricing)).setText("$" + ticketPricing);
        ((TextView)findViewById(R.id.salesTax)).setText("$" + moneyFormat.format(salesTaxPrice));
        ((TextView)findViewById(R.id.totalPrice)).setText("$" + moneyFormat.format(totalPrice));
    }
}