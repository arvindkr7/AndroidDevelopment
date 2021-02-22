package com.example.tms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeDemo extends AppCompatActivity {
    TextView dp, tp, tv_output;
    Button okay, cancel;
    int year, month, day, hr, mint;
    boolean is24hr = false;
    CharSequence time, currtime, date, finalCharSeq;
    String timeText;
    String title="Physics";
    Calendar calendar = Calendar.getInstance();
    final Calendar current = Calendar.getInstance();

    private NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_demo);
        notificationHelper = new NotificationHelper(DateTimeDemo.this);
        dp = findViewById(R.id.dpdemo);
        tp = findViewById(R.id.tpdemo);
        tv_output = findViewById(R.id.tv_dateTime);
        tv_output.setVisibility(View.INVISIBLE);
        okay = findViewById(R.id.btn_okay);
        cancel = findViewById(R.id.btn_task_cancel);
        calendar.set(Calendar.AM_PM,0);
        calendar.set(Calendar.SECOND,0);
        currtime =DateFormat.format("hh:mm a",current);

        //displayDate();
        //displayTime();

        // Calendar instance gives the current day and time






        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeDemo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                         year = i;
                        month= i1;
                        day = i2;
                        // updated the latest information
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, day);

                        displayDate();
                        displayDateTime();

                    }



                }, year, month, day);
                    datePickerDialog.getDatePicker().setMinDate(current.getTimeInMillis());
                    // date before today is not possible to set any reminder

                datePickerDialog.show();

            }
        });

        tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimeDemo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        hr = i;
                        mint = i1;

                        calendar.set(Calendar.HOUR, hr);
                        calendar.set(Calendar.MINUTE, mint);

                        if (verify()){
                        displayTime();}


                    }
                }, hr, mint, is24hr);

                timePickerDialog.show();


            }

        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAlarm();
            }
        });


    }

    public boolean verify(){

        if (calendar.before(current)){
            tv_output.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Time must be ahead of "+currtime, Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            displayDateTime();
            tv_output.setVisibility(View.VISIBLE);
            return true;
        }


    }

    private void updateTimeText(){
        timeText = java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT).format(calendar.getTime());
    }

    public void displayDateTime(){
        finalCharSeq = DateFormat.format("hh:mm a - E dd MMM", calendar);
        tv_output.setText(finalCharSeq);
    }

    public void displayDate(){



        date = DateFormat.format("E dd MMM", calendar);
        dp.setText(date);
    }

    public void displayTime(){

        time =DateFormat.format("hh:mm a",calendar);
        tp.setText(time);

    }



    public void setAlarm(){

        if (verify()) {

            Intent i = new Intent(DateTimeDemo.this, ReminderBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(DateTimeDemo.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            long timeinMillis = calendar.getTimeInMillis();

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeinMillis, pendingIntent);
            Toast.makeText(DateTimeDemo.this, "Reminder set for " +timeText , Toast.LENGTH_LONG).show();

        }




    }

    public void cancelAlarm(){
        Intent i = new Intent(DateTimeDemo.this, ReminderBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(DateTimeDemo.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm cancelled!", Toast.LENGTH_SHORT).show();
    }

    public void sendNotification(View view){
        NotificationCompat.Builder nb= notificationHelper.getChannelNotification(title, finalCharSeq);
        notificationHelper.getManager().notify(1, nb.build());
    }


}