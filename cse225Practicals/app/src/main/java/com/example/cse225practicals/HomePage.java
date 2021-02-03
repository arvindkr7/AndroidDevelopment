package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
        Button alarm, notification, datepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        alarm = findViewById(R.id.btn_goto_Alarm);
        notification = findViewById(R.id.btn_goto_Notification);
        datepicker = findViewById(R.id.btn_goto_DatePicker);

        // implement on click methods

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, P10DemoAlarm.class);
                startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, NotificationDemo.class);
                startActivity(intent);
            }
        });

        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, DateTimePickerThroughxml.class);
                startActivity(intent);
            }
        });
    }
}