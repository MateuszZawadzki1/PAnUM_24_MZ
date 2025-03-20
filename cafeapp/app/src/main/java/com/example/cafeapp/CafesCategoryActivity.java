package com.example.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CafesCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafes_category);
        if (Cafe.cafes == null || Cafe.cafes.length == 0) {
            throw new RuntimeException("Tablica Cafe.cafes jest pusta!");
        }


        ListView listCafes = (ListView) findViewById(R.id.list_cafes);

        ArrayAdapter<Cafe> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Cafe.cafes);

        listCafes.setAdapter(listAdapter);

        listCafes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listCafes,
                                    View itemView,
                                    int position,
                                    long id) {
                Intent intent = new Intent(CafesCategoryActivity.this,
                        CafeActivity.class);
                intent.putExtra(CafeActivity.EXTRA_CAFEID, (int) id);
                startActivity(intent);
            }
        });
    }
}
