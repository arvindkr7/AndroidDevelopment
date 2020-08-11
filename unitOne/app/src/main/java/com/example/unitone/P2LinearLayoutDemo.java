package com.example.unitone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class P2LinearLayoutDemo extends AppCompatActivity implements View.OnClickListener {
    Button clearbtn, submitbtn, cancelledbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_linear_layout_demo);
        clearbtn=findViewById(R.id.ClearButton);
        submitbtn=findViewById(R.id.SubmitButton);
        cancelledbtn=findViewById(R.id.CancelledButton);

        clearbtn.setOnClickListener(this);
        submitbtn.setOnClickListener(this);
        cancelledbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ClearButton:
                System.out.println("Clear Button clicked");
                break;

            case R.id.SubmitButton:
                System.out.println("Submit Button clicked");
                break;
            case R.id.CancelledButton:
                System.out.println("Cancelled Button clicked");
                break;
        }
    }
}