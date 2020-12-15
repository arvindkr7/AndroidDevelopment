package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

    public class MainActivity extends AppCompatActivity {
    final String[] activities = {
            "MainActivity.class"
    };
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.anim);
        imageView.setBackgroundResource(R.drawable.launch_animation1);
        animationDrawable = (AnimationDrawable) imageView.getBackground();

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                animationDrawable.start();
//            }
//        });
    }

        @Override
        protected void onStart() {
            super.onStart();
            animationDrawable.start();
        }
    }