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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class welcome extends AppCompatActivity {
ImageView imageView;
TextView txtEmail;
EditText edtName;
boolean hasCaptured=false;
boolean hasBrowsed=false;
boolean hasName=false;
Bitmap bitmap;
String userEmail, userName, toastMsg;
int requestCode=7;

Button capture;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setTitle(R.string.welcome);
        setContentView(R.layout.activity_welcome);
        imageView=findViewById(R.id.showImg);
        txtEmail=findViewById(R.id.txtEmail);
        edtName=findViewById(R.id.inputUserName);
       Intent i=getIntent();
       userEmail=i.getStringExtra("userEmail");
       userName=i.getStringExtra("userName");
       bitmap=(Bitmap)i.getParcelableExtra("welcomeImg");


       if (userEmail!=null) {
            txtEmail.setText(userEmail);
           showToast("Welcome! "+userEmail+" for registering :)");
       }
       if (userName!=null){
           edtName.setText(userName);
       }
       if (bitmap!=null){
           imageView.setImageBitmap(bitmap);
           hasCaptured=true;
       }


       capture=findViewById(R.id.btnPicture);
       capture.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent captureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(captureIntent, requestCode);
           }
       });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==requestCode){
            bitmap =(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            hasCaptured=true;

        }else{
            hasCaptured=false;
            showToast( "Unable to open camera");
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void browse(View view){
       hasBrowsed=true;
      Intent i= new Intent(Intent.ACTION_WEB_SEARCH);
       i.setData(Uri.parse("https://www.google.com"));
       startActivity(i);
    }

    public void submit(View view){
       userName= edtName.getText().toString();
       hasName=!userName.matches("");
       if (hasCaptured){
           showToast("Information saved successfully.");
        Intent i=new Intent(this, registerStatus.class);
        i.putExtra("welcomeImg", bitmap);
        i.putExtra("userEmail",userEmail);
        i.putExtra("userName",userName);

        startActivity(i);
       }
       else{
           if (!hasCaptured){
           showToast("Capture the image first to continue...");
           }
           else if (!hasBrowsed){

               showToast("You didn't browse");
           }
           else if (!hasName){
               showToast("Name field is empty");
           }
       }


    }
    protected  void showToast(String msg){
        Toast.makeText(welcome.this, msg, Toast.LENGTH_SHORT).show();
    }
}