package com.example.healthandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuySupplementsBookActivity extends AppCompatActivity {
    EditText edname, edaddress, edcontact, edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_supplements_book);

        edname = findViewById(R.id.editTextBSBFullName);
        edaddress = findViewById(R.id.editTextBSBAddress);
        edcontact = findViewById(R.id.editTextBSBContact);
        edpincode = findViewById(R.id.editTextBSBPincode);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");


        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username", "").toString();

                DatabaseHelper db = new DatabaseHelper(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(),"", Float.parseFloat(price[1].toString()), "lab");
                db.removeCart(username, "supplements");
                Toast.makeText(getApplicationContext(), "Your Booking Was Successfull", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuySupplementsBookActivity.this, HomeActivity.class));


            }
        });
    }
}