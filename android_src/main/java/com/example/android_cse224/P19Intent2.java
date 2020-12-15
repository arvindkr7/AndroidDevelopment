package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class P19Intent2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p19_intent2);

        Intent i = getIntent();
        String uname = i.getStringExtra("uname");
        String pass  = i.getStringExtra("pass");
        Toast.makeText(getApplicationContext(), "Logged in as " + uname + " Pass: " + pass, Toast.LENGTH_SHORT).show();
    }
}