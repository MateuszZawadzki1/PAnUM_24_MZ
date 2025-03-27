package com.example.conv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button numberSystemButton = findViewById(R.id.number_system_button);
        Button currencyButton = findViewById(R.id.currency_button);
        Button unitsButton = findViewById(R.id.units_button);

        numberSystemButton.setOnClickListener(v -> startActivity(new Intent(this, NumberSystemActivity.class)));
        currencyButton.setOnClickListener(v -> startActivity(new Intent(this, CurrencyActivity.class)));
        unitsButton.setOnClickListener(v -> startActivity(new Intent(this, UnitsActivity.class)));
    }
}