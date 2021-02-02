package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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
                Toast.makeText(NotificationDemo.this, "check notification ", Toast.LENGTH_SHORT).show();

                String msg= "This is a notification example";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationDemo.this)
                        .setSmallIcon(R.drawable.ic_baseline_text_format_24)
                        .setContentTitle("New Notification Title")
                        .setContentText(msg)
                        .setAutoCancel(true);


                Intent intent = new Intent(NotificationDemo.this, NotificationLandingPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("msg",msg);

                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationDemo.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                // Notification Manager
                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(0, builder.build());
            }
        });
    }




}