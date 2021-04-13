package com.example.tablayoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager viewPager;

    FloatingActionButton floatingActionButton;


    // firstly create ViewPagerAdapter
    // object of ViewPagerAdapter class custom created



    // create list of getInstance of each fragment

    String[] tabs = {"Chats", "Status", "Calls"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        getTabs();
        // adding tabs

        // below is a hard coding method for adding tabs

        /*
        for(String t:tabs){
            tabLayout.addTab(tabLayout.newTab().setText(t));
        }

         */

        floatingActionButton = findViewById(R.id.floatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFloatingActionButton();
            }
        });



    }

    public void getTabs(){


        // getSupportFragmentManager for fragments in the viewPager
       final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);



       new Handler().post(new Runnable() {
           @Override
           public void run() {

               // now add each fragments to the adapter
               viewPagerAdapter.addFragment(ChatsFragment.getInstance(), tabs[0]);
               viewPagerAdapter.addFragment(StatusFragment.getInstance(), tabs[1]);
               viewPagerAdapter.addFragment(CallsFragment.getInstance(), tabs[2]);


               // now set adapter to viewPager

               viewPager.setAdapter(viewPagerAdapter);


               // connect ViewPager with tabLayout
               tabLayout.setupWithViewPager(viewPager);
           }
       });




    }

    public void setFloatingActionButton(){



        Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
        startActivity(intent);
    }

}