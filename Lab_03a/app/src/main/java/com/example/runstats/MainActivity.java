package com.example.runstats;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateFromPace(View view) {
        EditText paceInput = findViewById(R.id.Temp);
        EditText distanceInput = findViewById(R.id.distance);

        try {
            double pace = Double.parseDouble(paceInput.getText().toString());
            double customDistance = distanceInput.getText().toString().isEmpty() ?
                    0 : Double.parseDouble(distanceInput.getText().toString());

            double speed = 60 / pace;

            String marathonTime = calculateTime(42.195, pace);
            String halfMarathonTime = calculateTime(21.0975, pace);
            String customTime = customDistance > 0 ? calculateTime(customDistance, pace) : "Podaj dystans";

            ((TextView)findViewById(R.id.speedResult)).setText(String.format("Prędkość: %.2f km/h", speed));
            ((TextView)findViewById(R.id.marathonResult)).setText("Maraton: " + marathonTime);
            ((TextView)findViewById(R.id.halfMarathonResult)).setText("Półmaraton: " + halfMarathonTime);
            ((TextView)findViewById(R.id.customDistanceResult)).setText("Własny dystans: " + customTime);

        } catch (NumberFormatException e) {
            ((TextView)findViewById(R.id.speedResult)).setText("Wprowadź poprawne dane");
        }
    }

    public void calculatePace(View view) {
        EditText distanceInput = findViewById(R.id.targetDistance);
        EditText timeInput = findViewById(R.id.targetTime);

        try {
            double distance = Double.parseDouble(distanceInput.getText().toString());
            double time = Double.parseDouble(timeInput.getText().toString());

            double pace = time / distance;
            double speed = 60 / pace;

            ((TextView)findViewById(R.id.paceResult)).setText(
                    String.format("Tempo: %.2f min/km\nPrędkość: %.2f km/h", pace, speed)
            );

        } catch (NumberFormatException e) {
            ((TextView)findViewById(R.id.paceResult)).setText("Wprowadź poprawne dane");
        }
    }

    private String calculateTime(double distance, double pace) {
        double totalMinutes = distance * pace;
        int hours = (int)(totalMinutes / 60);
        int minutes = (int)(totalMinutes % 60);
        int seconds = (int)((totalMinutes * 60) % 60);

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }
}