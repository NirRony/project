package com.example.nirronyhossain.smarthouserent.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nirronyhossain.smarthouserent.Pojo_Class.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalDatabaseSource {

    private RentalDatabaseHelper rentalDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public RentalDatabaseSource(Context context){
        rentalDatabaseHelper = new RentalDatabaseHelper(context);
    }

    private  void open(){
        sqLiteDatabase = rentalDatabaseHelper.getWritableDatabase();
    }

    private void close(){
        rentalDatabaseHelper.close();
    }

    public boolean insertRental(Rental rental){
        this.open();
        ContentValues values = new ContentValues();
        values.put(RentalDatabaseHelper.COL_RENTAL_NAME, rental.getRental_name());
        values.put(RentalDatabaseHelper.COL_RENTAL_EMAIL, rental.getRental_email());
        values.put(RentalDatabaseHelper.COL_RENTAL_PASSWORD, rental.getRental_password());
        values.put(RentalDatabaseHelper.COL_RENTAL_MOBILE_NUMBER, rental.getRental_mobile_number());
        values.put(RentalDatabaseHelper.COL_RENTAL_NID, rental.getRental_nid());
        values.put(RentalDatabaseHelper.COL_RENTAL_ADDRESS, rental.getRental_address());
        values.put(RentalDatabaseHelper.COL_RENTAL_LOCATION, rental.getRental_location());
        long insertedRowId = sqLiteDatabase.insert(RentalDatabaseHelper.TABLE_RENTAL, null, values);
        this.close();
        if (insertedRowId > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public List<Rental> getAllRentals(){
        this.open();
        List<Rental>rentals = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+RentalDatabaseHelper.TABLE_RENTAL,null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int rowId = cursor.getInt(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_ID));
                String name = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_NAME));
                String email = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_PASSWORD));
                int mobile_number = cursor.getInt(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_MOBILE_NUMBER));
                int nid = cursor.getInt(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_NID));
                String address = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_ADDRESS));
                String location = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_LOCATION));

                rentals.add(new Rental(rowId,name,email,password,mobile_number,nid,address,location));
            }while (cursor.moveToNext());
        }
        cursor.close();
        this.close();
        return rentals;
    }

    public Rental getRentalById(int rowId){
        this.open();
        Rental rental = null;
        Cursor cursor =
                sqLiteDatabase.rawQuery("select * from "+RentalDatabaseHelper.TABLE_RENTAL
                                +" where "+RentalDatabaseHelper.COL_RENTAL_ID+" = "+rowId,
                        null);
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_NAME));
            String email = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_EMAIL));
            String password = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_NAME));
            int mobile_number = cursor.getInt(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_MOBILE_NUMBER));
            int nid = cursor.getInt(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_NID));
            String address = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_ADDRESS));
            String location = cursor.getString(cursor.getColumnIndex(RentalDatabaseHelper.COL_RENTAL_LOCATION));

            rental = new Rental(rowId,name,email,password, mobile_number, nid, address, location);
        }
        this.close();
        return rental;
    }
}
