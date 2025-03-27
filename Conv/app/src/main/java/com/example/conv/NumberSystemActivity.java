package com.example.conv;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NumberSystemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_system);

        EditText numberInput = findViewById(R.id.number_input);
        Button convertButton = findViewById(R.id.convert_button);
        TextView binaryResult = findViewById(R.id.result_binary);
        TextView quaternaryResult = findViewById(R.id.result_quaternary);
        TextView octalResult = findViewById(R.id.result_octal);
        TextView hexResult = findViewById(R.id.result_hex);

        convertButton.setOnClickListener(v -> {
            String input = numberInput.getText().toString();
            if (!input.isEmpty()) {
                int number = Integer.parseInt(input);
                binaryResult.setText("Dwójkowo: " + Integer.toBinaryString(number));
                quaternaryResult.setText("Czwórkowo: " + Integer.toString(number, 4));
                octalResult.setText("Ósemkowo: " + Integer.toOctalString(number));
                hexResult.setText("Szesnastkowo: " + Integer.toHexString(number).toUpperCase());
            }
        });
    }
}