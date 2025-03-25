package com.example.cafeapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String category = getIntent().getStringExtra("CATEGORY");
        ListView listView = findViewById(R.id.list_items);

        CoffeinaDatabaseHelper dbHelper = new CoffeinaDatabaseHelper(this);
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.query("PRODUCT",
                    new String[]{"_id", "NAME"},
                    "CATEGORY = ?",
                    new String[]{category},
                    null, null, null);

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                Intent intent = new Intent(CategoryActivity.this, ItemActivity.class);
                intent.putExtra("ITEM_ID", (int) id);
                startActivity(intent);
            });
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