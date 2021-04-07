package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DetailActivity extends AppCompatActivity {
    Button btnBack;
    TextView tvUname, tvPass;


    FileInputStream fileInputStream;

    String fileName = "credentials.text";
    String fileDir = "dir";

    File externalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvUname  =findViewById(R.id.tv_uname_detail);
        tvPass = findViewById(R.id.tv_pass_detail);




        try {

            externalFile = new File(getExternalFilesDir(fileDir), fileName);

            fileInputStream = new FileInputStream(externalFile);

            StringBuffer stringBuffer = new StringBuffer();
        int i;

            while ((i=fileInputStream.read())!=-1){
                stringBuffer.append((char)i);


            }
            fileInputStream.close();

            String[] details = stringBuffer.toString().split("\n");
            tvUname.setText(details[0]);
            tvPass.setText(details[1]);
            //tvUname.setText(stringBuffer.toString());


        }catch (FileNotFoundException e){
            Log.i("filenotfounderror", e.toString());
            e.printStackTrace();
        }
        catch (IOException e){
            Log.i("ioexception", e.toString());
            e.printStackTrace();
        }


        btnBack = findViewById(R.id.btn_back_detail);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}