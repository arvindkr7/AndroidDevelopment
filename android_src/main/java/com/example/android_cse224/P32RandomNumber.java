package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class P32RandomNumber extends AppCompatActivity {
    EditText editText;
    int attempts = 0;
    int r_num = (new Random()).nextInt(31) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p32_random_number);
        editText = findViewById(R.id.edit_text);
    }

    public void luckyDraw(View v) {
        int num = Integer.parseInt(editText.getText().toString());
        attempts++;

        if ( num == r_num)
            Toast.makeText(getApplicationContext(), "Congrats!! Attempts: " + attempts, Toast.LENGTH_SHORT).show();
        else if (num < r_num)
            Toast.makeText(getApplicationContext(), "Try Higher date!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Try lower date!", Toast.LENGTH_SHORT).show();

    }
}