package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nirronyhossain.smarthouserent.DataBase.AddPostDatabaseSource;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.AddPost;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LandLoderAddPost extends AppCompatActivity {

    private final int SELECT_PHOTO = 1;
    private ImageView imageView;
    private Button pickImage;
    private byte[] image;

    private Spinner location, category, bed, bath, dinig, drawing, garages, balcony;
    private EditText size, price, address;

    private String post_location, post_category, post_dinig, post_drawing, post_garages,  post_address, post_bed, post_bath, post_balcony;
    private int post_size, post_price;

    private AddPostDatabaseSource addPostDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_loder_add_post);

        addPostDatabaseSource = new AddPostDatabaseSource(this);

        imageView = (ImageView)findViewById(R.id.imageView);

        pickImage = (Button) findViewById(R.id.btn_pick);
        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });


        location = findViewById(R.id.spinner_Location);
        category = findViewById(R.id.spinner_Category);
        bed = findViewById(R.id.spinner_Bed);
        bath = findViewById(R.id.spinner_Bath);
        dinig = findViewById(R.id.spinner_Dining);
        drawing = findViewById(R.id.spinner_Drawing);
        garages = findViewById(R.id.spinner_Garages);
        balcony = findViewById(R.id.spinner_Balcony);
        size = findViewById(R.id.editText_size);
        price = findViewById(R.id.editText_price);
        address = findViewById(R.id.editText_address);


        String[] cities = getResources().getStringArray(R.array.cityAreaName);
        ArrayAdapter<String> location_adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities );
        location.setAdapter(location_adapter);
        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_location = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        String[] Category = getResources().getStringArray(R.array.category);
        ArrayAdapter<String> category_adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Category );
        category.setAdapter(category_adapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_category = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] Bed_Bath_Balcony = getResources().getStringArray(R.array.bed_bath_balcony);
        ArrayAdapter<String> Bed_Bath_Balcony_adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Bed_Bath_Balcony );
        bed.setAdapter(Bed_Bath_Balcony_adapter);
        bath.setAdapter(Bed_Bath_Balcony_adapter);
        balcony.setAdapter(Bed_Bath_Balcony_adapter);
        bed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_bed = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        bath.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_bath = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        balcony.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_balcony = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] Dining_Drawing_Garages = getResources().getStringArray(R.array.dining_drawing_garages);
        ArrayAdapter<String> Dining_Drawing_Garages_adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Dining_Drawing_Garages);
        dinig.setAdapter(Dining_Drawing_Garages_adapter);
        drawing.setAdapter(Dining_Drawing_Garages_adapter);
        garages.setAdapter(Dining_Drawing_Garages_adapter);
        dinig.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_dinig = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        drawing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_drawing = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        garages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                post_garages = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);



                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                        image = baos.toByteArray();



                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void addpost(View view) {
        post_size = Integer.parseInt(size.getText().toString());
        post_price = Integer.parseInt(price.getText().toString());
        post_address = address.getText().toString();




        if (post_address.isEmpty()){
            address.setError(getString(R.string.empty_field_error_msg));
            return;
        }

        AddPost addPost = new AddPost(image, post_location, post_category, post_bed, post_bath, post_dinig, post_drawing, post_garages, post_size, post_price, post_balcony, post_address);

        boolean status = addPostDatabaseSource.insertAddPost(addPost);

        if (status){
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LandLoderAddPost.this, AddPostList.class);

            startActivity(intent);
        }
        else {
            Toast.makeText(this, "failed to saved", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LandLoderAddPost.this, RentalList.class);
            startActivity(intent);
        }


    }
}
