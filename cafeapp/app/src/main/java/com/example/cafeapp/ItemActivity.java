package com.example.cafeapp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        int itemId = getIntent().getIntExtra("ITEM_ID", -1);
        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);
        ImageView photo = findViewById(R.id.photo);
        Button addToCartButton = findViewById(R.id.add_to_cart_button);

        CoffeinaDatabaseHelper dbHelper = new CoffeinaDatabaseHelper(this);
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.query("PRODUCT",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RES_ID"},
                    "_id = ?",
                    new String[]{String.valueOf(itemId)},
                    null, null, null);

            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String descText = cursor.getString(1);
                int imageResId = cursor.getInt(2);

                Log.d("ItemActivity", "name: " + nameText + ", imageResId: " + imageResId);

                name.setText(nameText);
                description.setText(descText);
                photo.setImageResource(imageResId);
                photo.setContentDescription(nameText);

                addToCartButton.setOnClickListener(v -> {
                    Cart.addItem(new CartItem(nameText, imageResId));
                    Toast.makeText(this, nameText + " dodano do koszyka", Toast.LENGTH_SHORT).show();
                });
            }
        } catch (SQLiteException e) {
            Toast.makeText(this, "Baza danych niedostępna", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cursor != null) cursor.close();
        if (db != null) db.close();
    }
}