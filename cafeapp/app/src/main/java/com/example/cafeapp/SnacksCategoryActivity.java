package com.example.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SnacksCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_category);
        if (Snack.snacks == null || Snack.snacks.length == 0) {
            throw new RuntimeException("Tablica Snack.snack jest pusta!");
        }


        ListView listSnacks = (ListView) findViewById(R.id.list_snacks);

        ArrayAdapter<Snack> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Snack.snacks);

        listSnacks.setAdapter(listAdapter);

        listSnacks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listSnacks,
                                    View itemView,
                                    int position,
                                    long id) {
                Intent intent = new Intent(SnacksCategoryActivity.this,
                        SnackActivity.class);
                intent.putExtra(SnackActivity.EXTRA_SNACKID, (int) id);
                startActivity(intent);
            }
        });
    }
}
