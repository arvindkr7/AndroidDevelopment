package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class P12GridLayout_Images extends AppCompatActivity {
    GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p12_grid_layout__images);


        grid = findViewById(R.id.image_grid);
    }
    public void image_number(View view) {
        for (int i = 0; i < grid.getChildCount(); i++) {
            if (grid.getChildAt(i) == view) {
                Toast.makeText(getApplicationContext(), (i + 1) + " Clicked!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}