package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class p4_star_RatingBar extends AppCompatActivity {
    Button btn1;
    RatingBar rb1;
    float rating;
    int numOfStars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_star__rating_bar);

        btn1= findViewById(R.id.btn1);
        rb1= findViewById(R.id.rb1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rating = rb1.getRating();
                numOfStars= rb1.getNumStars();
                String msg = "Rating: "+Float.toString(rating) + "Num of Stars: "+Integer.toString(numOfStars);
                Toast.makeText(p4_star_RatingBar.this,msg , Toast.LENGTH_SHORT).show();

            }
        });
    }
}