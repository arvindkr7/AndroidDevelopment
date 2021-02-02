package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class P10DemoAlarm extends AppCompatActivity {
    EditText etTime;
    Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_demo_alarm);
        etTime = findViewById(R.id.edt_get_time);
        btnSet = findViewById(R.id.btn_set_alarm);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String duration= etTime.getText().toString();
                Toast.makeText(P10DemoAlarm.this, "Alarm will ring in: "+duration+" sec", Toast.LENGTH_SHORT).show();
                int time = Integer.parseInt(duration);
                Intent i = new Intent(P10DemoAlarm.this, AlarmBroadCastReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + time * 1000, pendingIntent);

            }
        });

    }
}