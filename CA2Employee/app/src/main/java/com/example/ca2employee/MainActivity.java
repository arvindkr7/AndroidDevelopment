package com.example.ca2employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null) return;

        // it will add the first fragment in the FrameLayout by default
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main, new EmployeeListFragment()).commit();

    }
}