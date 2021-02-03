package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class DateTimePickerThroughxml extends AppCompatActivity {
    DatePicker dp;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker_throughxml);
        dp = findViewById(R.id.demo_dp);
        submit = findViewById(R.id.btn_dp_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1; // starts from 0-based
                int year = dp.getYear();
                int dayOfWeek = dp.getFirstDayOfWeek();


                Toast.makeText(DateTimePickerThroughxml.this, dayOfWeek+", "+day+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
            }
        });
    }
}