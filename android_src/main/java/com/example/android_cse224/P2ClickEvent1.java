package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class P2ClickEvent1 extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_click_event1);

        // There are 3 different ways to create click event listener
        // 3 methods
        // 1. Registering event Listener
        // 2. From XML File
        // 4. By creating Anonymous Class

        b1 = (Button)findViewById(R.id.but1);
        b2 = (Button)findViewById(R.id.but2);
        b1.setOnClickListener(this); // register the onCLick to the button
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.but1: System.out.println("Button1 Pressed!"); break;
            case R.id.but2: System.out.println("Button2 Pressed!"); break;
        }
    }

    // Created from XML
    public void clickMe(View view) {
        System.out.println("Button3 clicked!(Method by XML)");
    }
}