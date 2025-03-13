package com.example.timer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class StopwatchFragment extends Fragment {
    private TextView stopwatch1, stopwatch2;
    private Button startStopwatch1, startStopwatch2;
    private long time1 = 0, time2 = 0;
    private boolean running1 = false, running2 = false;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        stopwatch1 = view.findViewById(R.id.stopwatch1);
        stopwatch2 = view.findViewById(R.id.stopwatch2);
        startStopwatch1 = view.findViewById(R.id.startStopwatch1);
        startStopwatch2 = view.findViewById(R.id.startStopwatch2);

        startStopwatch1.setOnClickListener(v -> toggleStopwatch(1));
        startStopwatch2.setOnClickListener(v -> toggleStopwatch(2));

        updateStopwatch(1);
        updateStopwatch(2);

        return view;
    }

    private void toggleStopwatch(int stopwatchNumber) {
        if (stopwatchNumber == 1) {
            running1 = !running1;
            startStopwatch1.setText(running1 ? "Stop" : "Start");
            if (running1) handler.post(updateRunnable1);
        } else {
            running2 = !running2;
            startStopwatch2.setText(running2 ? "Stop" : "Start");
            if (running2) handler.post(updateRunnable2);
        }
    }

    private Runnable updateRunnable1 = new Runnable() {
        @Override
        public void run() {
            if (running1) {
                time1 += 10;
                updateStopwatch(1);
                handler.postDelayed(this, 10);
            }
        }
    };

    private Runnable updateRunnable2 = new Runnable() {
        @Override
        public void run() {
            if (running2) {
                time2 += 10;
                updateStopwatch(2);
                handler.postDelayed(this, 10);
            }
        }
    };

    private void updateStopwatch(int stopwatchNumber) {
        long time = (stopwatchNumber == 1) ? time1 : time2;
        int minutes = (int) (time / 60000);
        int seconds = (int) (time / 1000) % 60;
        int hundredths = (int) (time / 10) % 100;
        String timeString = String.format("%02d:%02d.%02d", minutes, seconds, hundredths);
        if (stopwatchNumber == 1) stopwatch1.setText(timeString);
        else stopwatch2.setText(timeString);
    }
}