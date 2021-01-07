package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.Toast;

public class p2HorizontalScrollView extends AppCompatActivity {
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6;
    HorizontalScrollView scrlvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_horizontal_scroll_view);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("btn1 clicked");
            }
        });
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("btn2 clicked");
            }
        });
        scrlvw = findViewById(R.id.scrlvw);
        scrlvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("btn clicked");
            }
        });
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}