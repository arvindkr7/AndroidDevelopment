package com.example.android_cse224;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class P30AlertDialog2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p30_alert_dialog2);
    }

    public void openDialog(View view) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Dialog");
        alertDialog.setMessage("This is Dialog");
        alertDialog.setCancelable(false);

        final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(this);
        alertDialog.setTitle("Dialog1");
        alertDialog.setMessage("This is Dialog 1");
        alertDialog.setCancelable(false);

        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);
        alertDialog.setTitle("Dialog2");
        alertDialog.setMessage("This is Dialog 2");
        alertDialog.setCancelable(false);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog1.show();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog2.show();
            }
        });

        alertDialog.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();
    }
}