package com.example.tms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcastReceiver extends BroadcastReceiver {

    String title, desc;
    private NotificationHelper notificationHelper;
    @Override
    public void onReceive(Context context, Intent intent) {

        //sendNotification();
        Bundle b= intent.getExtras();
        title = b.getString("title");
        desc = b.getString("desc");



        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mediaPlayer.start();


        Toast.makeText(context, "Alarm ringing title "+title +" Desc "+desc, Toast.LENGTH_LONG).show();

        //vibrate phone
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(3000);


    }

    public void sendNotification(){
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(title,desc);
        notificationHelper.getManager().notify(1, nb.build());
    }
}
