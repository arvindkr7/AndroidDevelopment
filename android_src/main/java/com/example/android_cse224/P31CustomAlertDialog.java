package com.example.android_cse224;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class P31CustomAlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p31_custom_alert_dialog);
    }

    public void alert(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        // Add spinner in the custom layout
        final Spinner spinner = view1.findViewById(R.id.my_spinner);
        String[] arr = {"Item 1", "Item 2"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr);
        spinner.setAdapter(arrayAdapter);
        alertDialog.setTitle("Custom Dialog");

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (spinner.getSelectedItem().toString().equals("Item 2"))
                    Toast.makeText(getApplicationContext(), "Congratulation!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Ooops!", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setView(view1);
        alertDialog.show();
    }
}