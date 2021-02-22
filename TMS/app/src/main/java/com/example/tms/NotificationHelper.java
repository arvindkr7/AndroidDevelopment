package com.example.tms;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID="channelID";
    public static final String channelName = "Channel 1";

    private  NotificationManager nManager;
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
        createChannel();}
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void createChannel(){
        NotificationChannel notificationChannel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLightColor(R.color.purple_200);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(notificationChannel);
    }

    public NotificationManager getManager(){
        if (nManager==null )
            // otherwise already existing
            nManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        return  nManager;
    }


    public NotificationCompat.Builder getChannelNotification(String title, CharSequence msg){
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(R.drawable.ic_round_library_add_check_24);



    }
}
