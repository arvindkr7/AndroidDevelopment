package com.example.ca1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    ArrayList al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spin);
        al=new ArrayList();
        al.add("Music");
        al.add("Classic");
        al.add("Rock");
        al.add("Jazz");

        ArrayAdapter ap= new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, al);
        ap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ap);
    }
}