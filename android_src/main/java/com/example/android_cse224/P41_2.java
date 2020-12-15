package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class P41_2 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p41_2);
        score = getIntent().getIntExtra("SCORE", 0);
    }

    public void quit(View view) {
        RadioButton btn = findViewById(R.id.option2);
        if (btn.isChecked())  score++;
        Toast.makeText(getApplicationContext(),"Your score is: " + score, Toast.LENGTH_SHORT).show();
    }
}