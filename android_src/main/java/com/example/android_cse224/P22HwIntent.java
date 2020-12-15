package com.example.android_cse224;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class P22HwIntent extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p22_hw_intent);
        img = findViewById(R.id.img);
    }
    public void open_url(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.co.in"));
        startActivity(i);
    }

    public void capture_image(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);

    }

    public void dial(View v) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + "123456789"));
        startActivity(i);
    }

    public void open_gallery(View v) {
        // Intent i = new Intent();
        // i.setType("images/*");
        // i.setAction(Intent.ACTION_GET_CONTENT);
        // startActivityForResult(Intent.createChooser(i, "Select Picture"), 1);
        Intent i = new Intent(Intent.ACTION_VIEW, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(i);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }
    }
}