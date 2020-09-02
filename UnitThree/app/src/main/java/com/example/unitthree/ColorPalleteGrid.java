package com.example.unitthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ColorPalleteGrid extends AppCompatActivity {
    TextView bx1, bx2, bx3, bx4, bx5, bx6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_pallete_grid);
        bx1=findViewById(R.id.bx1);
        bx2=findViewById(R.id.bx2);
        bx3=findViewById(R.id.bx3);
        bx4=findViewById(R.id.bx4);
        bx5=findViewById(R.id.bx5);
        bx6=findViewById(R.id.bx6);
    }

    public void check(View view) {
        String msg="Box no. ";
        switch (view.getId()){
            case R.id.bx1:
                msg+=bx1.getText().toString();
                break;

            case R.id.bx2:
                msg+=bx2.getText().toString();
                break;
            case R.id.bx3:
                msg+=bx3.getText().toString();
                break;
            case R.id.bx4:
                msg+=bx4.getText().toString();
                break;
            case R.id.bx5:
                msg+=bx5.getText().toString();
                break;
            case R.id.bx6:
                msg+=bx6.getText().toString();
                break;
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();



    }
}