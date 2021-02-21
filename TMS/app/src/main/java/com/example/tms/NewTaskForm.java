package com.example.tms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.time.LocalDate;
import java.time.LocalTime;

public class NewTaskForm extends AppCompatActivity {
    Button cancel, submit;
    EditText subName, taskTime, taskDay, taskDate;
    String sub,time, day, date;
    int hr, mnt;
    LocalDate currDate = LocalDate.now();
    LocalTime currTime = LocalTime.now();
    int position= -1; // default value that means new object to be created else edit the existing one
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_form);
        subName = findViewById(R.id.et_addNewTaskSubjectName);
        taskTime = findViewById(R.id.et_addNewTaskTime);
        taskDay = findViewById(R.id.et_addNewTaskDay);
        taskDate = findViewById(R.id.et_addNewTasDate);
        cancel = findViewById(R.id.btn_newTaskFormCancel);
        submit = findViewById(R.id.btn_newTaskFormSubmit);

            // listen for incoming message through intent
        Bundle b = getIntent().getExtras();
        if (b!=null){
            position = b.getInt("position");
            sub = b.getString("name");
            time = b.getString("time");
            day = b.getString("day");
            date = b.getString("date");

            subName.setText(sub);
            taskTime.setText(time);
            taskDay.setText(day);
            taskDate.setText(date);

        }




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sub = subName.getText().toString();
               time = taskTime.getText().toString();
               day = taskDay.getText().toString();
               date= taskDate.getText().toString();


                Toast.makeText(NewTaskForm.this, sub+time+day+date, Toast.LENGTH_SHORT).show();
                goback();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });


    }

    public void goback(){
        Intent i = new Intent(this, MainActivity.class);

            i.putExtra("position", position);
            i.putExtra("name", sub);
            i.putExtra("time", time);
            i.putExtra("day", day);
            i.putExtra("date", date);

        startActivity(i);
    }


}