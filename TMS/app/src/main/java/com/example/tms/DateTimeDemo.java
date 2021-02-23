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
    EditText et;
    Button okay, cancel;
    int year, month, day, hr, mint;
    boolean is24hr = false;
    CharSequence time, currtime, date, finalCharSeq;
    String timeText;
    String name="Task name"; // for notification purpose
    Calendar receivedCalendar = Calendar.getInstance();
    final Calendar current = Calendar.getInstance();
    Calendar updatedCalendar = receivedCalendar;
    int position = -1;

    private NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_demo);
        notificationHelper = new NotificationHelper(DateTimeDemo.this);
        dp = findViewById(R.id.dpdemo);
        tp = findViewById(R.id.tpdemo);
        et = findViewById(R.id.taskName);
        tv_output = findViewById(R.id.tv_dateTime);
        tv_output.setVisibility(View.INVISIBLE);
        okay = findViewById(R.id.btn_okay);
        cancel = findViewById(R.id.btn_task_cancel);
        receivedCalendar.set(Calendar.AM_PM,0);
        receivedCalendar.set(Calendar.SECOND,0);
        currtime =DateFormat.format("hh:mm a",current);

        //displayDate();
        //displayTime();

        // Calendar instance gives the current day and time

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){

            position = bundle.getInt("position");
            name = bundle.getString("name");
            year = bundle.getInt("year");
            month = bundle.getInt("month");
            day = bundle.getInt("date");
            hr = bundle.getInt("hr");
            mint = bundle.getInt("mint");
            onreceiving(receivedCalendar);

        }






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
                        updatedCalendar.set(Calendar.YEAR, year);
                        updatedCalendar.set(Calendar.MONTH, month);
                        updatedCalendar.set(Calendar.DAY_OF_MONTH, day);

                        displayDate(updatedCalendar);
                        displayDateTime(updatedCalendar);

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

                        updatedCalendar.set(Calendar.HOUR, hr);
                        updatedCalendar.set(Calendar.MINUTE, mint);


                        displayTime(updatedCalendar);


                    }
                }, hr, mint, is24hr);

                timePickerDialog.show();


            }

        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cancel(receivedCalendar);
                //cancelAlarm();
                toastMsg("Cancelled!");
            }
        });

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //setAlarm();
                save(updatedCalendar);

            }
        });


    }

    public boolean verify(){

        if (updatedCalendar.before(current)){
            tv_output.setVisibility(View.INVISIBLE);
            String msg="Time must be ahead of "+currtime;
            toastMsg(msg);
            return false;
        }
        else{
            displayDateTime(updatedCalendar);
            tv_output.setVisibility(View.VISIBLE);
            return true;
        }


    }

    public void displayTaskName(){
        et.setText(name);
    }

    private void updateTimeText(){
        timeText = java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT).format(updatedCalendar.getTime());
    }


    public void displayDateTime(Calendar c){
        finalCharSeq = DateFormat.format("hh:mm a - E dd MMM", c);

        tv_output.setText(finalCharSeq);
        tv_output.setVisibility(View.VISIBLE);
    }

    public void displayDate(Calendar c){



        date = DateFormat.format("E dd MMM", c);
        dp.setText(date);
    }

    public void displayTime(Calendar c){

        time =DateFormat.format("hh:mm a",c);
        tp.setText(time);

    }

    public void onreceiving(Calendar c){

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR, hr);
        c.set(Calendar.MINUTE, mint);

        displayTaskName();
        displayDate(c);
        displayTime(c);
        displayDateTime(c);



    }

    public void cancel(Calendar c){
        Intent i = new Intent(DateTimeDemo.this, MainActivity.class);
        startActivity(i);
    }

    public void save(Calendar c){
        Intent i = new Intent(DateTimeDemo.this, MainActivity.class);
        if (verify()) {

            toastMsg("Saved successfully!");
            name = et.getText().toString();
            i.putExtra("position", position);
            i.putExtra("name", name);
            i.putExtra("year", c.get(Calendar.YEAR));
            i.putExtra("month", c.get(Calendar.MONTH));
            i.putExtra("date", c.get(Calendar.DAY_OF_MONTH));
            i.putExtra("hr", c.get(Calendar.HOUR));
            i.putExtra("mint", c.get(Calendar.MINUTE));


            setAlarm();
        }
        startActivity(i);
    }



    public void setAlarm(){

        if (verify()) {

            Intent i = new Intent(DateTimeDemo.this, ReminderBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(DateTimeDemo.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            long timeinMillis = updatedCalendar.getTimeInMillis();

            updateTimeText();
            toastMsg("Reminder set for "+timeText);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeinMillis, pendingIntent);


            //sendNotification();
        }




    }

    public void cancelAlarm(){
        Intent i = new Intent(DateTimeDemo.this, ReminderBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(DateTimeDemo.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm cancelled!", Toast.LENGTH_SHORT).show();
    }

    public void sendNotification(){
        NotificationCompat.Builder nb= notificationHelper.getChannelNotification(name, finalCharSeq);
        notificationHelper.getManager().notify(1, nb.build());
    }

    public void toastMsg(String msg){
        Toast.makeText(DateTimeDemo.this, msg, Toast.LENGTH_SHORT).show();
    }


}