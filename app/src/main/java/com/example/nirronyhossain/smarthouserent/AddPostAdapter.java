package com.example.nirronyhossain.smarthouserent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nirronyhossain.smarthouserent.DataBase.AddPostDatabaseSource;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.AddPost;

import java.util.List;

public class AddPostAdapter extends ArrayAdapter<AddPost> {

    private Context context;
    private List<AddPost> addPostlList;
    private AddPostDatabaseSource source;

    public AddPostAdapter(@NonNull Context context, List<AddPost> objects) {
        super(context, R.layout.post_row, objects);
        this.context = context;
        this.addPostlList = objects;
        source = new AddPostDatabaseSource(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.post_row, parent, false);

       // ImageView profile_photo = convertView.findViewById(R.id.profilePicture_id);
        TextView price = convertView.findViewById(R.id.price_id);
        TextView location = convertView.findViewById(R.id.location_id);
        TextView bed = convertView.findViewById(R.id.bed_id);
        TextView bath = convertView.findViewById(R.id.bath_id);
        TextView size = convertView.findViewById(R.id.size_id);


       // profile_photo.setImageResource(addPostlList.get(position).get);
        price.setText(String.valueOf(addPostlList.get(position).getPost_price()));
        location.setText(addPostlList.get(position).getPost_location());
        bed.setText(addPostlList.get(position).getPost_bed());
        bath.setText(addPostlList.get(position).getPost_bath());
        size.setText(String.valueOf(addPostlList.get(position).getPost_size()));


        return convertView;
    }
}
