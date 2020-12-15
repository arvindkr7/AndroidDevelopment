package com.example.android_cse224;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class P29AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p29_alert_dialog);
    }

    public void alert(View view) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("My Initial Alert Dialog");
        adb.setMessage("My First Message");
        adb.setCancelable(false);

        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "Positive Button", Toast.LENGTH_SHORT).show();
            }});

        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "Negative Button", Toast.LENGTH_SHORT).show();
            }});

        adb.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(), "Neutral Button", Toast.LENGTH_SHORT).show();
            }});

        AlertDialog alertDialog = adb.create();
        alertDialog.show();
    }
}