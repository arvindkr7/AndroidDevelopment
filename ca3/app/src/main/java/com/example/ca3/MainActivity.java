package com.example.ca3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        final TextView tv = findViewById(R.id.tv);
        // Boolean array for initial selected items
        final boolean[] checkedSubjects = new boolean[]{
                false, // Red
                true, // Green
                false, // Blue
                true, // Purple
                false // Olive

        };
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // String array for alert dialog multi choice items
                final String[] subjects = new String[]{
                        "Physics",
                        "Chemistry",
                        "Maths",
                        "English",
                        "Hindi"
                };



                // Convert the color array to list

                builder.setMultiChoiceItems(subjects, checkedSubjects, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        // Update the current focused item's checked status
                        checkedSubjects[which] = isChecked;

                        // Get the current focused item
                        String currentItem = subjects[which];

                        String selectUnselect;

                        if (isChecked){
                            selectUnselect= " selected";
                        }else{
                            selectUnselect= " unselected";
                        }

                        // Notify the current action
                        Toast.makeText(getApplicationContext(),
                                currentItem + selectUnselect, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                builder.setTitle("Your Compulsory subjects?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        tv.setText("Your compulsory subjects..... \n");
                        boolean noneSelected=true;
                        for (int i = 0; i<checkedSubjects.length; i++){
                            boolean checked = checkedSubjects[i];
                            if (checked) {
                                noneSelected=false;
                                tv.setText(tv.getText() + subjects[i] + "\n");
                            }
                        }
                        if (noneSelected){
                            tv.setText(tv.getText()+ "None, yet");
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "nothing", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}