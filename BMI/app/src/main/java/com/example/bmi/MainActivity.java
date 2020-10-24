package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnMale, btnFemale, btnWeightDecr, getBtnWeightIncr, btnAgeDecr, btnAgeIncr, btnCalc;
    TextView txtHeight, txtWeight, txtAge;
    SeekBar seekHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}