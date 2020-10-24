package com.example.ca2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.InetAddresses;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class welcome extends AppCompatActivity {
ImageView imageView;
boolean isCaptured=false;
Bitmap bitmap;
String user;

Button capture;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.welcome);
        setContentView(R.layout.activity_welcome);
        imageView=findViewById(R.id.showImg);
       Intent i=getIntent();
       user=i.getStringExtra("userName");

       if (user!=null) {

           Toast.makeText(this, "Welcome for registering the user name you entered is " + user, Toast.LENGTH_SHORT).show();
       }

       capture=findViewById(R.id.btnPicture);
       capture.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent captureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


               startActivityForResult(captureIntent, 7);
           }
       });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==7){
            bitmap =(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            isCaptured=true;

        }else{
            isCaptured=false;
            Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void browse(View view){
      Intent i= new Intent(Intent.ACTION_WEB_SEARCH);
       i.setData(Uri.parse("https://www.google.com"));
       startActivity(i);
    }

    public void submit(View view){
        Intent i=new Intent(this, registerStatus.class);
        i.putExtra("welcomeImg", bitmap);
        i.putExtra("name",user);

        startActivity(i);
    }
}