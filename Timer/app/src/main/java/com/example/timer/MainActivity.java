package com.example.timer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStopwatches = findViewById(R.id.btnStopwatches);
        Button btnTimers = findViewById(R.id.btnTimers);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new StopwatchFragment())
                .commit();

        btnStopwatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new StopwatchFragment())
                        .commit();
            }
        });

        btnTimers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new com.example.timer.TimerFragment())
                        .commit();
            }
        });
    }
}