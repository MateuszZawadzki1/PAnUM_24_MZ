package com.example.cafeapp;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    private Drink (String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Drink[] drinks;

    static {
        drinks = new Drink[]{
                new Drink("Espresso", "Mocna, aromatyczna kawa bez mleka.", R.drawable.espresso),
                new Drink("Cappuccino", "Kawa z mlekiem i puszystą pianką.", R.drawable.cappuccino),
                new Drink("Cold Brew", "Kawa parzona na zimno przez kilkanaście godzin.", R.drawable.coldbrew),
                new Drink("Drip", "Kawa przelewowa parzona metodą alternatywną.", R.drawable.drip),
                new Drink("Matcha", "Zielona herbata w proszku, spieniona z mlekiem lub wodą.", R.drawable.matcha)
        };
    }

    public String getDescription() {
        return description;
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
