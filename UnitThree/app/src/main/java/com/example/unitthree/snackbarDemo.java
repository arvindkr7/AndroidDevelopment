package com.example.unitthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class snackbarDemo extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar_demo);
        btn=findViewById(R.id.demoBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is a demo of Snackbar", Snackbar.LENGTH_LONG).setAction(
                        "Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast t= Toast.makeText(getApplicationContext(), "You clicked Retry", Toast.LENGTH_SHORT);
                                t.setGravity(Gravity.TOP| Gravity.RIGHT, 0, 0);
                                t.show();
                            }
                        }
                ).show();
            }
        });
    }
}