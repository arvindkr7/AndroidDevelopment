package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.Inet4Address;

public class NotificationDemo extends AppCompatActivity {
    Button btnPushNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);

        // register the application for listening the notification on a particular channel
        btnPushNotification = findViewById(R.id.btn_push_notification);

        btnPushNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotificationDemo.this, "Toast message goes here", Toast.LENGTH_SHORT).show();
            }
        });
    }




}