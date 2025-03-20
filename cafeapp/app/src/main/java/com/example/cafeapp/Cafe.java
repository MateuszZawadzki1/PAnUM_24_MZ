package com.example.cafeapp;

public class Cafe {
    private String name;
    private int imageResourceId;

    private Cafe (String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public static final Cafe[] cafes;

    static {
        cafes = new Cafe[]{
                new Cafe("Czestochowa", R.drawable.czestochowa),
                new Cafe("Krakow", R.drawable.krakow),
                new Cafe("Warszawa", R.drawable.warszawa),
        };
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
