package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etUname, etPass;
    Button btnSave;

    // firstly add external write permission in Manifest file
    // file name
    String fileName = "credentials.text";

    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUname = findViewById(R.id.et_uname_main);
        etPass = findViewById(R.id.et_pass_main);
        btnSave = findViewById(R.id.btn_save_main);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    // firstly checking if read and write permissions granted
                    if (ContextCompat.checkSelfPermission(MainActivity.this, permissions[0]) != PackageManager.PERMISSION_GRANTED ||
                            ContextCompat.checkSelfPermission(MainActivity.this, permissions[1]) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(MainActivity.this, permissions, 34);
                    }


                    String name = etUname.getText().toString() + "\n";
                    String pass = etPass.getText().toString();


                    // validation

                    if (name.isEmpty() || pass.isEmpty()) {
                        showToast("Can't be empty");
                        return; // terminates the program ahead
                    }

                    // checking privileges

                    String state = Environment.getExternalStorageState();

                    if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
                        showToast("Only read permission allowed");
                    } else if (state.equals(Environment.MEDIA_MOUNTED)) {
                        showToast("REad and write permission available");
                    } else {
                        showToast("no external permission available");
                    }

                    // now creating file in external storage directory

                    File file = new File(getExternalFilesDir("dir"), fileName);
                    try {
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(name.getBytes());
                        fileOutputStream.write(pass.getBytes());
                        fileOutputStream.close();

                        showToast("Credential stored successfully in file");
                        gotoNext();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }


            }
        });
    }

    public void gotoNext(){
        Intent intent = new Intent(this, DetailActivity.class);

        startActivity(intent);
    }


    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}