package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class P41 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p41);
    }

    public void nextQuestion(View view) {
        RadioButton btn = findViewById(R.id.option2);
        int score = 0;
        if (btn.isChecked())
            score++;
        Intent intent = new Intent(this, P41_2.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }
}