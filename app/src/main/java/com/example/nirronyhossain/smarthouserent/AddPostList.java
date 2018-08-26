package com.example.nirronyhossain.smarthouserent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nirronyhossain.smarthouserent.DataBase.AddPostDatabaseSource;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.AddPost;

import java.util.List;

public class AddPostList extends AppCompatActivity {

    private AddPostDatabaseSource addPostDatabaseSource;
    private ListView addListView;
    AddPost ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post_list);

        addListView = findViewById(R.id.addpost_list);
        addPostDatabaseSource = new AddPostDatabaseSource(this);

        List<AddPost> addPost = addPostDatabaseSource.getAll_AddPost();
        if (addPost != null){
            final AddPostAdapter addPostAdapter = new AddPostAdapter(this, addPost);
            addListView.setAdapter(addPostAdapter);
            addListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    ap = addPostAdapter.getItem(i);

                    Intent intent = new Intent(AddPostList.this, AddPostDetails.class);

                    intent.putExtra("POST_ID", ap.getPost_rowID());
                    intent.putExtra("IMAGE", ap.getPost_image());
                    intent.putExtra("LOCATION", ap.getPost_location());
                    intent.putExtra("CATEGORY", ap.getPost_category());
                    intent.putExtra("BED", ap.getPost_bed());
                    intent.putExtra("BATH", ap.getPost_bath());
                    intent.putExtra("DINING", ap.getPost_dining());
                    intent.putExtra("DRAWING", ap.getPost_drawing());
                    intent.putExtra("GARAGE", ap.getPost_garage());
                    intent.putExtra("SIZE", ap.getPost_size());
                    intent.putExtra("PRICE", ap.getPost_price());
                    intent.putExtra("BALCONY", ap.getPost_balcony());
                    intent.putExtra("ADDRESS", ap.getPost_address());

                    startActivity(intent);
                }
            });


        }
    }
}
