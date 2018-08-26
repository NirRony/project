package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nirronyhossain.smarthouserent.DataBase.RentalDatabaseSource;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.Rental;

import java.util.List;

public class RegistrationForm1 extends AppCompatActivity {
    public static List<Rental> rentals;
    private String name, email, password, address, location;
    private int mobie_number, nid;

    private EditText registration_mobile_number_editText, registration_NID_editText, registration_address_editText;
    private Spinner registration_address_spinner;

    private RentalDatabaseSource rentalDatabaseSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form1);

        registration_mobile_number_editText = findViewById(R.id.registrationMobileNumberID);
        registration_NID_editText = findViewById(R.id.registrationNidID);
        registration_address_editText = findViewById(R.id.registrationAddressID);
        registration_address_spinner = findViewById(R.id.addreesSpinnerButtonID);
        rentalDatabaseSource = new RentalDatabaseSource(this);

        String[] cities = getResources().getStringArray(R.array.cityAreaName);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities );
        registration_address_spinner.setAdapter(adapter);
        registration_address_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                location = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { } });    }

    public void RegistrationButtonID2(View view) {

        name = getIntent().getStringExtra("NAME");
        email = getIntent().getStringExtra("EMAIL");
        password = getIntent().getStringExtra("PASSWORD");

        mobie_number = Integer.parseInt(registration_mobile_number_editText.getText().toString());
        nid = Integer.parseInt(registration_NID_editText.getText().toString());
        address = registration_address_editText.getText().toString();



        Rental rental = new Rental(name, email, password, mobie_number, nid, address, location);

        boolean status = rentalDatabaseSource.insertRental(rental);

        if (status){
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(RegistrationForm1.this, RentalList.class);

            startActivity(intent);
        }
        else {
            Toast.makeText(this, "failed to saved", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistrationForm1.this, RentalList.class);
            startActivity(intent);
        }


    }
}
