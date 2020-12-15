package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class P15Snackbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p15_snackbar);
    }

    public void clickedMe(View view) {
        final LinearLayout view1 = findViewById(R.id.view1);
        Snackbar.make(view1 , "An Error Occurred!", Snackbar.LENGTH_LONG) .setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view1, "Success!", Snackbar.LENGTH_SHORT).show();
            }
        }).show();
//        Toast.makeText(this, "hey", Toast.LENGTH_SHORT).show();
//
//        Toast t = Toast.makeText(getApplicationContext(), "Hey again", Toast.LENGTH_SHORT);
//        t.setText(R.string.app_name);
//        t.setGravity(Gravity.LEFT, 20, 20);
//        t.setDuration(Toast.LENGTH_SHORT);
//        t.show();
    }
}