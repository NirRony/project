package com.example.nirronyhossain.smarthouserent.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RentalDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "rental_database";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_RENTAL = "table_rental";
    public static final String COL_RENTAL_ID= "_id";
    public static final String COL_RENTAL_NAME = "rental_name";
    public static final String COL_RENTAL_EMAIL = "rental_email";
    public static final String COL_RENTAL_PASSWORD= "rental_password";
    public static final String COL_RENTAL_MOBILE_NUMBER = "rental_mobile_number";
    public static final String COL_RENTAL_NID = "rental_nid";
    public static final String COL_RENTAL_ADDRESS= "rental_address";
    public static final String COL_RENTAL_LOCATION = "rental_location";

    public RentalDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+TABLE_RENTAL+"("+
                COL_RENTAL_ID+" integer primary key, "+
                COL_RENTAL_NAME+" text, "+
                COL_RENTAL_EMAIL+" text, "+
                COL_RENTAL_PASSWORD+" text, "+
                COL_RENTAL_MOBILE_NUMBER+" integer, "+
                COL_RENTAL_NID+" integer, "+
                COL_RENTAL_ADDRESS+" text, "+
                COL_RENTAL_LOCATION+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
