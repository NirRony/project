package com.example.nirronyhossain.smarthouserent.Pojo_Class;

public class AddPost {
    private int post_rowID;

    private byte[] post_image;
    private String post_location;
    private String post_category;
    private String post_bed;
    private String post_bath;
    private String post_dining;
    private String post_drawing;
    private String post_garage;
    private int post_size;
    private int post_price;
    private String post_balcony;
    private String post_address;

    public AddPost(int post_rowID, byte[] post_image, String post_location, String post_category, String post_bed, String post_bath, String post_dining, String post_drawing, String post_garage, int post_size, int post_price, String post_balcony, String post_address) {
        this.post_rowID = post_rowID;
        this.post_image = post_image;
        this.post_location = post_location;
        this.post_category = post_category;
        this.post_bed = post_bed;
        this.post_bath = post_bath;
        this.post_dining = post_dining;
        this.post_drawing = post_drawing;
        this.post_garage = post_garage;
        this.post_size = post_size;
        this.post_price = post_price;
        this.post_balcony = post_balcony;
        this.post_address = post_address;
    }

    public AddPost(byte[] post_image, String post_location, String post_category, String post_bed, String post_bath, String post_dining, String post_drawing, String post_garage, int post_size, int post_price, String post_balcony, String post_address) {
        this.post_image = post_image;
        this.post_location = post_location;
        this.post_category = post_category;
        this.post_bed = post_bed;
        this.post_bath = post_bath;
        this.post_dining = post_dining;
        this.post_drawing = post_drawing;
        this.post_garage = post_garage;
        this.post_size = post_size;
        this.post_price = post_price;
        this.post_balcony = post_balcony;
        this.post_address = post_address;
    }

    public byte[] getPost_image() { return post_image; }

    public int getPost_rowID() { return post_rowID; }

    public String getPost_location() {
        return post_location;
    }

    public String getPost_category() {
        return post_category;
    }

    public String getPost_bed() {
        return post_bed;
    }

    public String getPost_bath() {
        return post_bath;
    }

    public String getPost_dining() {
        return post_dining;
    }

    public String getPost_drawing() {
        return post_drawing;
    }

    public String getPost_garage() {
        return post_garage;
    }

    public int getPost_size() { return post_size; }

    public int getPost_price() {
        return post_price;
    }

    public String getPost_balcony() {
        return post_balcony;
    }

    public String getPost_address() {
        return post_address;
    }
}

