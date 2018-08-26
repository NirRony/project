package com.example.nirronyhossain.smarthouserent.Pojo_Class;

import java.io.Serializable;

public class Rental implements Serializable{

    private int rowID;
    private String Rental_name;
    private String Rental_email;
    private String Rental_password;
    private int Rental_mobile_number;
    private int Rental_nid;
    private String Rental_address;
    private String Rental_location;

    public Rental(int rowID, String rental_name, String rental_email, String rental_password, int rental_mobile_number, int rental_nid, String rental_address, String rental_location) {
        this.rowID = rowID;
        Rental_name = rental_name;
        Rental_email = rental_email;
        Rental_password = rental_password;
        Rental_mobile_number = rental_mobile_number;
        Rental_nid = rental_nid;
        Rental_address = rental_address;
        Rental_location = rental_location;
    }

    public Rental(String rental_name, String rental_email, String rental_password, int rental_mobile_number, int rental_nid, String rental_address, String rental_location) {
        Rental_name = rental_name;
        Rental_email = rental_email;
        Rental_password = rental_password;
        Rental_mobile_number = rental_mobile_number;
        Rental_nid = rental_nid;
        Rental_address = rental_address;
        Rental_location = rental_location;
    }

    public int getRowID() {
        return rowID;
    }

    public String getRental_name() {
        return Rental_name;
    }

    public String getRental_email() {
        return Rental_email;
    }

    public String getRental_password() {
        return Rental_password;
    }

    public int getRental_mobile_number() {
        return Rental_mobile_number;
    }

    public int getRental_nid() {
        return Rental_nid;
    }

    public String getRental_address() {
        return Rental_address;
    }

    public String getRental_location() {
        return Rental_location;
    }
}
