package com.example.unitone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
Spinner sp;
ArrayList al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        sp=findViewById(R.id.Spin);
        al=new ArrayList();
        al.add(1);
        al.add(6);
        al.add(8);

        ArrayAdapter ap=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, al);
        ap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ap);
    }
}