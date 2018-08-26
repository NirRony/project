package com.example.nirronyhossain.smarthouserent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nirronyhossain.smarthouserent.DataBase.RentalDatabaseSource;
import com.example.nirronyhossain.smarthouserent.Pojo_Class.Rental;

import java.util.List;


public class RentalsAdapter extends ArrayAdapter<Rental> {
    private Context context;
    private List<Rental> rentalList;
    private RentalDatabaseSource source;
    Rental rn_adapter;

    public RentalsAdapter(@NonNull Context context, List<Rental> objects) {
        super(context, R.layout.rental_row, objects);
        this.context = context;
        this.rentalList = objects;
        source = new RentalDatabaseSource(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.rental_row, parent, false);


        TextView rental_list_name = convertView.findViewById(R.id.rentalNameId);
        TextView rental_list_email = convertView.findViewById(R.id.rentalEmailId);
      //  final int rowId = rentalList.get(position).getRowID();


        rental_list_name.setText(rentalList.get(position).getRental_name());
        rental_list_email.setText(rentalList.get(position).getRental_email());


        return convertView;
    }
}
