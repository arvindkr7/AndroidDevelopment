package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationLandingPage extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_landing_page);

        tv= findViewById(R.id.notificationTextViewDetails);

        String msg = getIntent().getStringExtra("msg");
        tv.setText(msg);

    }
}