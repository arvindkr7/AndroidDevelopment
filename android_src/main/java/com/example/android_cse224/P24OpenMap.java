package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class P24OpenMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p24_open_map);
    }
    // Implicit Intent (Open map with given coordinates)
    public void openMap(View v) {
        String loc = "geo:37.55, -122.546";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(loc));
        // i.setPackage("android.")
        startActivity(i);
    }
}