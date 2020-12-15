package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class P20IntentGetBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p20_intent_get_back);
    }
    public  void perform(View v) {
        Intent i = new Intent(this, P20IntentSendBack.class);
        startActivityForResult(i, 1);
    }
}