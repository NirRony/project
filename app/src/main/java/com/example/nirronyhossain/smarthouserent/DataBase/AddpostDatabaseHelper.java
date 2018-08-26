package com.example.nirronyhossain.smarthouserent.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AddpostDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME_ADD_POST = "add_post_database";
    public static final int DATABASE_VERSION_ADD_POST = 2;

    public static final String TABLE_ADD_POST = "table_add_post";
    public static final String COL_ADD_POST_ID = "_postid";
    public static final String COL_ADD_POST_IMAGE = "add_post_image";
    public static final String COL_ADD_POST_LOCATION = "add_post_location";
    public static final String COL_ADD_POST_ADDRESS = "add_post_address";
    public static final String COL_ADD_POST_CATEGORY = "add_post_category";
    public static final String COL_ADD_POST_BED = "add_post_bed";
    public static final String COL_ADD_POST_BATH= "add_post_bath";
    public static final String COL_ADD_POST_DINING = "add_post_dining";
    public static final String COL_ADD_POST_DRAWING = "add_post_drawing";
    public static final String COL_ADD_POST_GARAGES= "add_post_garages";
    public static final String COL_ADD_POST_SIZE = "add_post_size";
    public static final String COL_ADD_POST_PRICE = "add_post_price";
    public static final String COL_ADD_POST_BALCONY = "add_post_balcony";



    public AddpostDatabaseHelper(Context context) {
        super(context, DATABASE_NAME_ADD_POST, null, DATABASE_VERSION_ADD_POST);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+TABLE_ADD_POST+"("+
                COL_ADD_POST_ID+" integer primary key, "+
                COL_ADD_POST_IMAGE+" bitmap, "+
                COL_ADD_POST_LOCATION+" text, "+
                COL_ADD_POST_ADDRESS+" text, "+
                COL_ADD_POST_CATEGORY+" text, "+
                COL_ADD_POST_BED+" integer, "+
                COL_ADD_POST_BATH+" integer, "+
                COL_ADD_POST_DINING+" integer, "+
                COL_ADD_POST_DRAWING+" integer, "+
                COL_ADD_POST_GARAGES+" integer, "+
                COL_ADD_POST_SIZE+" integer, "+
                COL_ADD_POST_PRICE+" integer, "+
                COL_ADD_POST_BALCONY+" integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
