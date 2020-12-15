package com.example.android_cse224;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class P4HwForm1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_hw_form1);

        Button b1, b2, b3;
        final TextView form_action;
        final EditText user_name, user_id;
        user_name = findViewById(R.id.user_name);
        user_id = findViewById(R.id.user_id);
        form_action = findViewById(R.id.form_actions);

        b1 = findViewById(R.id.submit_btn);
        b2 = findViewById(R.id.clear_btn);
        b3 = findViewById(R.id.cancel_btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form_action.setText("Form Submit");
                form_action.setTextColor(Color.parseColor("#4CAF50"));
                System.out.println("Form Submitted");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name.setText("");
                user_id.setText("");
                form_action.setText("Form Cleared");
                form_action.setTextColor(Color.parseColor("#2196F3"));
                System.out.println("Form Cleared");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form_action.setText("Form Cancelled");
                form_action.setTextColor(Color.parseColor("#E91E63"));
                System.out.println("Form Cancelled");
            }
        });
    }
}