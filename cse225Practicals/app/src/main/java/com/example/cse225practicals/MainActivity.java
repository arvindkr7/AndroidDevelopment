package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    DemoBR b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.tv_battery_Percentage);

        b = new DemoBR(tv);
        registerReceiver(b, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    @Override
    protected  void  onDestroy(){
        super.onDestroy();
        unregisterReceiver(b);
    }
}