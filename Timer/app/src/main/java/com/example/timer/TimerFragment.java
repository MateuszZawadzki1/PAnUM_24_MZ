package com.example.timer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.timer.R;

public class TimerFragment extends Fragment {
    private TextView timer1, timer2;
    private EditText timerInput1, timerInput2;
    private Button startTimer1, startTimer2;
    private long time1 = 0, time2 = 0;
    private boolean running1 = false, running2 = false;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        timer1 = view.findViewById(R.id.timer1);
        timer2 = view.findViewById(R.id.timer2);
        timerInput1 = view.findViewById(R.id.timerInput1);
        timerInput2 = view.findViewById(R.id.timerInput2);
        startTimer1 = view.findViewById(R.id.startTimer1);
        startTimer2 = view.findViewById(R.id.startTimer2);

        startTimer1.setOnClickListener(v -> toggleTimer(1));
        startTimer2.setOnClickListener(v -> toggleTimer(2));

        updateTimer(1);
        updateTimer(2);

        return view;
    }

    private void toggleTimer(int timerNumber) {
        if (timerNumber == 1) {
            if (!running1 && time1 == 0) {
                String input = timerInput1.getText().toString();
                time1 = input.isEmpty() ? 0 : Long.parseLong(input) * 1000;
            }
            running1 = !running1;
            startTimer1.setText(running1 ? "Stop" : "Start");
            if (running1) handler.post(updateRunnable1);
        } else {
            if (!running2 && time2 == 0) {
                String input = timerInput2.getText().toString();
                time2 = input.isEmpty() ? 0 : Long.parseLong(input) * 1000;
            }
            running2 = !running2;
            startTimer2.setText(running2 ? "Stop" : "Start");
            if (running2) handler.post(updateRunnable2);
        }
    }

    private Runnable updateRunnable1 = new Runnable() {
        @Override
        public void run() {
            if (running1 && time1 > 0) {
                time1 -= 10;
                updateTimer(1);
                handler.postDelayed(this, 10);
            } else if (time1 <= 0) {
                running1 = false;
                startTimer1.setText("Start");
            }
        }
    };

    private Runnable updateRunnable2 = new Runnable() {
        @Override
        public void run() {
            if (running2 && time2 > 0) {
                time2 -= 10;
                updateTimer(2);
                handler.postDelayed(this, 10);
            } else if (time2 <= 0) {
                running2 = false;
                startTimer2.setText("Start");
            }
        }
    };

    private void updateTimer(int timerNumber) {
        long time = (timerNumber == 1) ? time1 : time2;
        int minutes = (int) (time / 60000);
        int seconds = (int) (time / 1000) % 60;
        int hundredths = (int) (time / 10) % 100;
        String timeString = String.format("%02d:%02d.%02d", minutes, seconds, hundredths);
        if (timerNumber == 1) timer1.setText(timeString);
        else timer2.setText(timeString);
    }
}