package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class DemoTimePicker extends AppCompatActivity {
    TimePicker tp;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_time_picker);
        tp= findViewById(R.id.tp);
        //tp.setHour(3);
        //tp.setMinute(30);
        //tp.setIs24HourView(true);

        submit = findViewById(R.id.btn_tp_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hr = tp.getHour();
                int min = tp.getHour();

                Toast.makeText(DemoTimePicker.this, hr+":"+min, Toast.LENGTH_SHORT).show();
            }
        });
    }
}