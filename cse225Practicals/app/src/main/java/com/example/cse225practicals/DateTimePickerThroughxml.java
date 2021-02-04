package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DateTimePickerThroughxml extends AppCompatActivity {
    DatePicker dp;
    Button submit;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker_throughxml);
        dp = findViewById(R.id.demo_dp);
        submit = findViewById(R.id.btn_dp_submit);
        tv= findViewById(R.id.tv_dp_msg);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // int day = dp.getDayOfMonth();
               // int month = dp.getMonth() + 1; // starts from 0-based
               // int year = dp.getYear();
                // method 2
                Calendar calendar = Calendar.getInstance();
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        tv.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                }, year, month, day);

        datePickerDialog.show();
        Toast.makeText(DateTimePickerThroughxml.this, day+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
            }
        });
    }
}