package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class p5_ProgressBar extends AppCompatActivity {
    int progress=0;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5__progress_bar);
        pb = findViewById(R.id.pb1);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress<100){
                    progress+=1;
                    pb.setProgress(progress);

                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        Toast.makeText(p5_ProgressBar.this, "Exception caught: "+e, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        t.start();
    }
}