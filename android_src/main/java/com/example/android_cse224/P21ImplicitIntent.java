package com.example.android_cse224;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class P21ImplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p21_implicit_intent);
    }
    public void perform(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // i.setAction(Intent.ACTION_IMAGE_CAPTURE);
        // i.setData(Uri.parse("https://www.google.co.in"));
        // startActivity(i);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}