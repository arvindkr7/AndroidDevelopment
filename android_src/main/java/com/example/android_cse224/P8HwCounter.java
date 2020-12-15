package com.example.android_cse224;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class P8HwCounter extends AppCompatActivity {
    TextView counter, counter_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p8_hw_counter);
        counter = (TextView) findViewById(R.id.counter_value);
        counter_info = (TextView) findViewById(R.id.counter_info);
    }

    public void increment(View view) {
        int val = Integer.parseInt(counter.getText().toString());
        if (val == 100)
            counter_info.setText("Counter Reached MAX!");
        else {
            counter.setText(Integer.toString(++val));
            counter_info.setText("Have Fun!");
        }

    }

    public void decrement(View view) {
        int val = Integer.parseInt(counter.getText().toString());
        if (val == 0)
            counter_info.setText("Counter Reached MIN!");
        else {
            counter.setText(Integer.toString(--val));
            counter_info.setText("Have Fun!");
        }
    }
}