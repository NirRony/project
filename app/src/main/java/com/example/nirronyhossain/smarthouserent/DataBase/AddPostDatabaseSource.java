package com.example.nirronyhossain.smarthouserent.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nirronyhossain.smarthouserent.Pojo_Class.AddPost;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.Rental;

import java.util.ArrayList;
import java.util.List;

public class AddPostDatabaseSource {

    private AddpostDatabaseHelper addpostDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public AddPostDatabaseSource(Context context){
        addpostDatabaseHelper = new AddpostDatabaseHelper(context);
    }

    private void open(){
        sqLiteDatabase = addpostDatabaseHelper.getWritableDatabase();
    }
    private void close(){
        addpostDatabaseHelper.close();
    }

    public boolean insertAddPost(AddPost addPost){
        this.open();
        ContentValues values = new ContentValues();
        values.put(AddpostDatabaseHelper.COL_ADD_POST_IMAGE, addPost.getPost_image());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_LOCATION, addPost.getPost_location());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_ADDRESS, addPost.getPost_address());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_CATEGORY, addPost.getPost_category());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_BATH, addPost.getPost_bath());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_BED, addPost.getPost_bed());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_DINING, addPost.getPost_dining());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_DRAWING, addPost.getPost_drawing());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_GARAGES, addPost.getPost_garage());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_BALCONY, addPost.getPost_balcony());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_SIZE, addPost.getPost_size());
        values.put(AddpostDatabaseHelper.COL_ADD_POST_PRICE, addPost.getPost_price());

        long inserted_AddPost_RowId = sqLiteDatabase.insert(AddpostDatabaseHelper.TABLE_ADD_POST, null, values);
        this.close();
        if (inserted_AddPost_RowId > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public List<AddPost> getAll_AddPost(){
        this.open();
        List<AddPost>addPosts = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+AddpostDatabaseHelper.TABLE_ADD_POST,null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int add_post_rowId = cursor.getInt(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_ID));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_IMAGE));
                String location =cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_LOCATION));
                String category =cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_CATEGORY));
                String bed = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_BED));
                String bath = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_BATH));
                String dinig =cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_DINING));
                String drawing =cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_DRAWING));
                String garages =cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_GARAGES));
                int size = cursor.getInt(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_SIZE));
                int price = cursor.getInt(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_PRICE));
                String balcony = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_BALCONY));
                String address =cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_ADDRESS));


                addPosts.add(new AddPost(add_post_rowId, image, location, category, bed, bath, dinig, drawing, garages,size, price, balcony, address));
            }while (cursor.moveToNext());
        }
        cursor.close();
        this.close();
        return addPosts;
    }

    public AddPost getAddPostById(int add_post_rowId) {
        this.open();
        AddPost addPost = null;
        Cursor cursor =
                sqLiteDatabase.rawQuery("select * from " + AddpostDatabaseHelper.TABLE_ADD_POST
                                +" where "+AddpostDatabaseHelper.COL_ADD_POST_ID+" = " +add_post_rowId,
                        null);
        if (cursor.moveToFirst()) {
            byte[] image = cursor.getBlob(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_IMAGE));
            String location = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_LOCATION));
            String category = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_CATEGORY));
            String bed = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_BED));
            String bath = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_BATH));
            String dinig = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_DINING));
            String drawing = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_DRAWING));
            String garages = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_GARAGES));
            int size = cursor.getInt(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_SIZE));
            int price = cursor.getInt(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_PRICE));
            String balcony = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_BALCONY));
            String address = cursor.getString(cursor.getColumnIndex(AddpostDatabaseHelper.COL_ADD_POST_ADDRESS));

            addPost = new AddPost(add_post_rowId, image, location, category, bed, bath, dinig, drawing, garages, size, price, balcony, address);

        }
        this.close();
        return addPost;
    }
}
