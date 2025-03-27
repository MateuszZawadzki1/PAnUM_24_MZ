package com.example.conv;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CurrencyActivity extends AppCompatActivity {
    private static final double[][] RATES = {
            {1.0, 0.25, 0.23, 0.20, 27.0},  // PLN
            {4.0, 1.0, 0.92, 0.80, 108.0}, // USD
            {4.35, 1.09, 1.0, 0.87, 118.0}, // EUR
            {5.0, 1.25, 1.15, 1.0, 135.0},  // GBP
            {0.037, 0.0093, 0.0085, 0.0074, 1.0} // JPY
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        EditText amountInput = findViewById(R.id.amount_input);
        Spinner fromCurrency = findViewById(R.id.from_currency);
        Spinner toCurrency = findViewById(R.id.to_currency);
        Button convertButton = findViewById(R.id.convert_currency_button);
        TextView result = findViewById(R.id.currency_result);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromCurrency.setAdapter(adapter);
        toCurrency.setAdapter(adapter);

        convertButton.setOnClickListener(v -> {
            String input = amountInput.getText().toString();
            if (!input.isEmpty()) {
                double amount = Double.parseDouble(input);
                int fromIndex = fromCurrency.getSelectedItemPosition();
                int toIndex = toCurrency.getSelectedItemPosition();
                double converted = amount * RATES[fromIndex][toIndex];
                result.setText("Wynik: " + String.format("%.2f", converted) + " " + toCurrency.getSelectedItem());
            }
        });
    }
}