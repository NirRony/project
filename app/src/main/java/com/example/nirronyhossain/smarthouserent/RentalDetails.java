package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nirronyhossain.smarthouserent.DataBase.RentalDatabaseSource;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalDetails extends AppCompatActivity {

    private TextView rental_id, name, email, password, mobileNumber,nid,address, location;


    String  Name, Email,  Password, Address, Location;
    int  Rental_id, Mobile, Nid;

    private RentalDatabaseSource rentalDatabaseSource;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_details);



        rental_id = findViewById(R.id.rowIdValue);
        name = findViewById(R.id.nameValue);
        email = findViewById(R.id.emailValue);
        password = findViewById(R.id.passwordValue);
        mobileNumber = findViewById(R.id.mobileNumberValue);
        nid = findViewById(R.id.nidValue);
        address = findViewById(R.id.addressValue);
        location = findViewById(R.id.locationValue);

        Intent intent = getIntent();

            Rental_id = getIntent().getIntExtra("ID", 00);
            Name = getIntent().getStringExtra("NAME");
            Email = getIntent().getStringExtra("EMAIL");
            Password = getIntent().getStringExtra("PASSWORD");
            Mobile = getIntent().getIntExtra("MOBILE", 1);
            Nid = getIntent().getIntExtra("NID", 1);
            Address = getIntent().getStringExtra("ADDRESS");
            Location = getIntent().getStringExtra("LOCATION");



       // int Rental_ID = Integer.parseInt(Rental_id);

        rental_id.setText(String.valueOf(Rental_id));
        name.setText(Name);
        email.setText(Email);
        password.setText(Password);
        mobileNumber.setText(String.valueOf(Mobile));
        nid.setText(String.valueOf(Nid));
        address.setText(Address);
        location.setText(Location);



    }
}
