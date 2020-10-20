package com.example.ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class registerStatus extends AppCompatActivity {
ImageView img;
TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.register_status);
        setContentView(R.layout.activity_register_status);
        name=findViewById(R.id.registerName);
        img=findViewById(R.id.registerImg);

        Intent intent=getIntent();
        String userName=intent.getStringExtra("name");
        Bitmap bitmap=(Bitmap)intent.getParcelableExtra("welcomeImg");

        name.setText(userName);
        img.setImageBitmap(bitmap);

        Snackbar snackbar= Snackbar.make(img, "register done", Snackbar.LENGTH_LONG).setAction("Back", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), welcome.class);
                startActivity(i);
            }
        });


        snackbar.show();




    }


}