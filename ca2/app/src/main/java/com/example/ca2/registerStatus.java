package com.example.ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class registerStatus extends AppCompatActivity {
ImageView img;
TextView name, email;
Button btnBack;
String userName, userEmail;
Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.register_status);
        setContentView(R.layout.activity_register_status);
        getSupportActionBar().hide();
        name=findViewById(R.id.registerName);
        img=findViewById(R.id.registerImg);
        email=findViewById(R.id.registerEmail);

        Intent intent=getIntent();
        userName=intent.getStringExtra("userName");
        userEmail=intent.getStringExtra("userEmail");
        bitmap=(Bitmap)intent.getParcelableExtra("welcomeImg");

        name.setText(userName);
        email.setText(userEmail);
        img.setImageBitmap(bitmap);
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(getApplicationContext(), welcome.class);
                i.putExtra("welcomeImg", bitmap);
                i.putExtra("userEmail",userEmail);
                i.putExtra("userName",userName);
                startActivity(i);
            }
        });

        Snackbar snackbar= Snackbar.make(img, "Registration done successfully.", Snackbar.LENGTH_LONG).setAction("Done", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                Toast.makeText(registerStatus.this, "Your registration is successfully received.", Toast.LENGTH_LONG).show();
            }
        });


        snackbar.show();




    }


}