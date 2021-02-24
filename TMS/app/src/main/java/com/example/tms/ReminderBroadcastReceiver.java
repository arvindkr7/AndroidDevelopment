package com.example.tms;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcastReceiver extends BroadcastReceiver {
    private  NotificationHelper notificationHelper;
    String title, desc;
    public static final String channelID = "TMSChannelID";


    @Override
    public void onReceive(Context context, Intent intent) {


        Bundle b = intent.getExtras();
        title = b.getString("title");
        desc = b.getString("desc");


        // clicking on Notification will bring to home page
        Intent mainIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent,0);

        // send notification
        sendNotification(context);


        Toast.makeText(context, "Tic tic... " + title + " Desc " + desc, Toast.LENGTH_LONG).show();


        // play default alarm tone of device

        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mediaPlayer.start();


        /*

        //vibrate phone
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
            vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
        }else{
            vibrator.vibrate(1000);
        }


         */





    }

    public void sendNotification(Context context) {
        // Notification Manager
        NotificationManager notificationManager =(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            // for API 26 and above
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){

            String channelName = "TMSActivityReminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            // create Notification Channel must for API 26 and above
            NotificationChannel notificationChannel = new NotificationChannel(channelID, channelName, importance);
            notificationManager.createNotificationChannel(notificationChannel);

        }


        // build the notification what to be sent
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelID)
                .setSmallIcon(R.drawable.ic_round_library_add_check_24)
                .setContentTitle(title)
                .setContentText(desc)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);



        // at last notify
        notificationManager.notify(1, builder.build());






    }
}
