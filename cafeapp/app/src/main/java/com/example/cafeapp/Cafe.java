package com.example.cafeapp;

public class Cafe {
    private String name;
    private int imageResourceId;

    private Cafe (String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }


    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String toString() {
        return this.name;
    }


}
