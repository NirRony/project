package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nirronyhossain.smarthouserent.DataBase.RentalDatabaseSource;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalList extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RentalDatabaseSource rentalDatabaseSource;
    private ListView rental_listView;
    Rental rn;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_list);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        rental_listView = findViewById(R.id.rental_list);
        rentalDatabaseSource = new RentalDatabaseSource(this);

        List<Rental> rentals = rentalDatabaseSource.getAllRentals();
        if (rentals != null){
            final RentalsAdapter rentalsAdapter = new RentalsAdapter(this, rentals);
            rental_listView.setAdapter(rentalsAdapter);
            rental_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    rn = rentalsAdapter.getItem(i);

                    Intent intent = new Intent(RentalList.this, RentalDetails.class);

                    intent.putExtra("ID", rn.getRowID());
                    intent.putExtra("NAME", rn.getRental_name());
                    intent.putExtra("EMAIL", rn.getRental_email());
                    intent.putExtra("PASSWORD", rn.getRental_password());
                    intent.putExtra("MOBILE", rn.getRental_mobile_number());
                    intent.putExtra("NID", rn.getRental_nid());
                    intent.putExtra("ADDRESS", rn.getRental_address());
                    intent.putExtra("LOCATION", rn.getRental_location());

                    startActivity(intent);
                }
            });

        }
    }

    public void addRental(View view) {
        startActivity(new Intent(this, RegistrationForm.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.nav_addposts:
                Intent addpost = new Intent(RentalList.this, LandLoderAddPost.class);
                startActivity(addpost);
                break;
        }

        DrawerLayout drawerLayout1 = findViewById(R.id.drawer_layout);
        drawerLayout1.closeDrawer(GravityCompat.START);

        return true;
    }
}
