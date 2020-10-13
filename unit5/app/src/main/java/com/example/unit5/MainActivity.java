package com.example.unit5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.dialogAlertBtn);
    }

    public void dialogAlert(View view){
        AlertDialog.Builder adb= new AlertDialog.Builder(this);
        adb.setTitle("Alert Dialog Box Title");
        adb.setMessage("Alert Dialog Box Message or Context goes here");
        adb.setCancelable(false);

        adb.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        adb.setNeutralButton("nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Do nothing", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog= adb.create();
        alertDialog.show();
    }
}