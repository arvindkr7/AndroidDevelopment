package com.example.cse225practicals;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DemoBR extends BroadcastReceiver{
    TextView tv;
    DemoBR(TextView v){
        tv=v;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //int i = intent.getExtra("level");
        Bundle bundle = intent.getExtras();
        int i = bundle.getInt("level");
        Toast.makeText(context, "Battery drained to  %"+i, Toast.LENGTH_SHORT).show();
    }
}
