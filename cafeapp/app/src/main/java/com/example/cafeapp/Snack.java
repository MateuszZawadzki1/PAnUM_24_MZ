package com.example.cafeapp;

public class Snack {
    private String name;
    private String description;
    private int imageResourceId;

    private Snack (String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Snack[] snacks;

    static {
        snacks = new Snack[]{
                new Snack("Ciastko Owsiane", "Chrupiące ciastko z pełnoziarnistych płatków owsianych.", R.drawable.ciastkoowsiane),
                new Snack("Miodownik", "Słodki przekładaniec z miodem i delikatnym kremem.", R.drawable.miodownik),
                new Snack("Sernik Nowojorski", "Kremowy sernik o gęstej konsystencji i subtelnym smaku.", R.drawable.serniknowojorski),
                new Snack("Brownie", "Wilgotne ciasto czekoladowe z intensywnym kakaowym aromatem.", R.drawable.brownie),
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
