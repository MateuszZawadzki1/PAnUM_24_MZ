package com.example.lab_02a;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void OnClickNumericButton(View view) {
        TextView textViewArabic = findViewById(R.id.ScreenArabic);
        TextView textViewRoman = findViewById(R.id.ScreenRoman);

        String text = textViewArabic.getText().toString();
        String textR = textViewRoman.getText().toString();

        // Buttons
        if (view.getId() == R.id.Button_1)
            text = text + "1";
        if (view.getId() == R.id.Button_2)
            text = text + "2";
        if (view.getId() == R.id.Button_3)
            text = text + "3";
        if (view.getId() == R.id.Button_4)
            text = text + "4";
        if (view.getId() == R.id.Button_5)
            text = text + "5";
        if (view.getId() == R.id.Button_6)
            text = text + "6";
        if (view.getId() == R.id.Button_7)
            text = text + "7";
        if (view.getId() == R.id.Button_8)
            text = text + "8";
        if (view.getId() == R.id.Button_9)
            text = text + "9";
        if (view.getId() == R.id.Button_0)
            text = text + "0";
        if (view.getId() == R.id.Button_CE) {
            text = "";
            textR = "";
        }
        if (view.getId() == R.id.Button_backspace) {
            if (!text.isEmpty())
                text = text.substring(0, text.length() - 1);
            if (!textR.isEmpty())
                textR = textR.substring(0, textR.length() - 1);
        }

        if (view.getId() == R.id.Button_M)
            textR = textR + "M";
        if (view.getId() == R.id.Button_L)
            textR = textR + "L";
        if (view.getId() == R.id.Button_C)
            textR = textR + "C";
        if (view.getId() == R.id.Button_D)
            textR = textR + "D";
        if (view.getId() == R.id.Button_I)
            textR = textR + "I";
        if (view.getId() == R.id.Button_V)
            textR = textR + "V";
        if (view.getId() == R.id.Button_X)
            textR = textR + "X";




        textViewArabic.setText(text);
        textViewRoman.setText(textR);

        Conventer conventer = new Conventer(text);
        textViewRoman.setText(conventer.arabicToR());
    }
}