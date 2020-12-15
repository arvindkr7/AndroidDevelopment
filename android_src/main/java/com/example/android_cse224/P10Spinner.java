package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class P10Spinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_spinner);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        String[] arr = {"RED", "BLUE", "YELLOW", "GREEN"};

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adp);
    }
}