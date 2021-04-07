package com.example.tablayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;


    String[] tabs = {"Chats", "Status", "Calls"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);



        // adding tabs
        for(String t:tabs){
            tabLayout.addTab(tabLayout.newTab().setText(t));
        }


    }
}