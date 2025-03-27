package com.example.cafeapp;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final List<CartItem> items = new ArrayList<>();

    public static void addItem(CartItem item) {
        items.add(item);
    }

    public static void removeItem(int position) {
        if (position >= 0 && position < items.size()) {
            items.remove(position);
        }
    }

    public static List<CartItem> getItems() {
        return items;
    }

    public static void clear() {
        items.clear();
    }
}

class CartItem {
    private String name;
    private int imageResId;

    public CartItem(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}