package com.example.ca2employee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EmployeeAdapter.callbackInterface{



    private static final int PICK_IMAGE = 1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        if (savedInstanceState!=null) return;

        // it will add the first fragment in the FrameLayout by default
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main, new EmployeeListFragment()).commit();






    }





    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void pickImage(){

        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
        gallery.setType("image/*");

        //gallery.setAction(Intent.ACTION_GET_CONTENT);

        // startActivityForResult(gallery, PICK_IMAGE);

        startActivityForResult(Intent.createChooser(gallery, "Select Profile Picture"), PICK_IMAGE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==PICK_IMAGE) {
            if (data != null) {
                imageUri = data.getData();
            }
        }
    }

    @Override
    public Uri onHandleSelection(Context context) {
        //showToast("position received "+position1);


        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
        gallery.setType("image/*");

        //gallery.setAction(Intent.ACTION_GET_CONTENT);

        // startActivityForResult(gallery, PICK_IMAGE);
        //
        ((Activity) context).startActivityForResult(Intent.createChooser(gallery, "Select Profile Picture"), PICK_IMAGE);



        return imageUri;
    }

}