package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AddPostDetails extends AppCompatActivity {

    private TextView post_id, location, address, category, bed, bath, dining, drawing, garage, balcony, size, price;
    private ImageView image;

    String  Location, Address, Category, Bed, Bath, Dining, Drawing, Garage, Balcony;
    int  Post_id, Size, Price;
    byte[] Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post_details);

        post_id = findViewById(R.id.post_rowIdValue);
        image = findViewById(R.id.post_ImageValue);
        location = findViewById(R.id.post_LocationValue);
        address = findViewById(R.id.post_AddressValue);
        category = findViewById(R.id.post_CategoryValue);
        bed = findViewById(R.id.post_BedValue);
        balcony = findViewById(R.id.post_BalconyValue);
        bath = findViewById(R.id.post_BathValue);
        dining = findViewById(R.id.post_DiningValue);
        drawing = findViewById(R.id.post_DrawingValue);
        garage = findViewById(R.id.post_GarageValue);
        size = findViewById(R.id.post_SizegValue);
        price = findViewById(R.id.post_PriceValue);

        Intent intent = getIntent();

        Post_id = getIntent().getIntExtra("POST_ID", 00);
        Image = getIntent().getByteArrayExtra("IMAGE");
        Location = getIntent().getStringExtra("LOCATION");
        Address = getIntent().getStringExtra("ADDRESS");
        Bed = getIntent().getStringExtra("BED");
        Bath = getIntent().getStringExtra("BATH");
        Dining = getIntent().getStringExtra("DINING");
        Drawing = getIntent().getStringExtra("DRAWING");
        Category = getIntent().getStringExtra("CATEGORY");
        Garage = getIntent().getStringExtra("GARAGE");
        Balcony = getIntent().getStringExtra("BALCONY");
        Size = getIntent().getIntExtra("SIZE", 1);
        Price = getIntent().getIntExtra("PRICE", 1);

        post_id.setText(String.valueOf(Post_id));
        location.setText(Location);
        address.setText(Address);
        category.setText(Category);
        bed.setText(Bed);
        bath.setText(Bath);
        dining.setText(Dining);
        drawing.setText(Drawing);
        garage.setText(Garage);
        balcony.setText(Balcony);
        size.setText(String.valueOf(Size));
        price.setText(String.valueOf(Price));

    }
}
