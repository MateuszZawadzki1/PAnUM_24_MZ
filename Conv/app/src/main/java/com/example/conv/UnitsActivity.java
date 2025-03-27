package com.example.conv;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UnitsActivity extends AppCompatActivity {
    private static final double[] LENGTH_FACTORS = {1.0, 10.0, 25.4, 304.8, 914.4, 1000.0, 1000000.0};
    private static final double[] AREA_FACTORS = {1.0, 100.0, 1000000.0, 1000000000000.0, 10000000.0, 100000000.0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);

        EditText unitInput = findViewById(R.id.unit_input);
        Spinner fromUnit = findViewById(R.id.from_unit);
        Spinner toUnit = findViewById(R.id.to_unit);
        Button convertButton = findViewById(R.id.convert_unit_button);
        TextView result = findViewById(R.id.unit_result);

        ArrayAdapter<CharSequence> lengthAdapter = ArrayAdapter.createFromResource(this,
                R.array.length_units, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(this,
                R.array.area_units, android.R.layout.simple_spinner_item);
        lengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromUnit.setAdapter(lengthAdapter);
        toUnit.setAdapter(lengthAdapter);

        convertButton.setOnClickListener(v -> {
            String input = unitInput.getText().toString();
            if (!input.isEmpty()) {
                double value = Double.parseDouble(input);
                int fromIndex = fromUnit.getSelectedItemPosition();
                int toIndex = toUnit.getSelectedItemPosition();
                double converted;

                if (fromUnit.getAdapter() == lengthAdapter) {
                    converted = value * LENGTH_FACTORS[fromIndex] / LENGTH_FACTORS[toIndex];
                    result.setText("Wynik: " + String.format("%.4f", converted) + " " + toUnit.getSelectedItem());
                } else {
                    converted = value * AREA_FACTORS[fromIndex] / AREA_FACTORS[toIndex];
                    result.setText("Wynik: " + String.format("%.4f", converted) + " " + toUnit.getSelectedItem());
                }
            }
        });

        fromUnit.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                if (position < 7) { // Dł
                    fromUnit.setAdapter(lengthAdapter);
                    toUnit.setAdapter(lengthAdapter);
                } else { // Pp
                    fromUnit.setAdapter(areaAdapter);
                    toUnit.setAdapter(areaAdapter);
                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });
    }
}