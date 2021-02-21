package com.example.tms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView lvSchedules, lvSubjects, lvCustom;
    Toolbar  toolbar;

    TaskAdapter taskAdapter;
    MyTasks myTasks;

    TaskModel tempTask;

    ArrayAdapter adapterSchedules, adapterSubjects;
    ArrayList <String> alSchedules = new ArrayList<>();
    ArrayList<String> alSubjects = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSchedules = findViewById(R.id.lv_Schedules);
        lvSubjects = findViewById(R.id.lv_Subjects);
        toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        lvCustom = findViewById(R.id.lv_custom);
        myTasks = ((MyApplication)this.getApplication()).getMyTasks();



        taskAdapter = new TaskAdapter(MainActivity.this, myTasks);

        lvCustom.setAdapter(taskAdapter);
        // listen for incoming message through intent
        Bundle b= getIntent().getExtras();
        //capture and store incoming data
        if (b!=null) {
            int position = b.getInt("position");
            String name = b.getString("name");
            String time = b.getString("time");
            String day = b.getString("day");
            String date = b.getString("date");

            // check if object existing then updated else add new object
            if (position!= -1){
                TaskModel t2= myTasks.getMyTasksList().get(position);

                t2.setSubName(name);
                t2.setTaskTime(time);
                t2.setTaskDay(day);
                t2.setTaskDate(date);
            }

            else {


                // create new TaskModel object with received data

                tempTask = new TaskModel(name, time, day, date);
                //add new task to list
                myTasks.getMyTasksList().add(tempTask);
            }

            // SORTING THE DATA


            // notify the adapter
            taskAdapter.notifyDataSetChanged();
        }

        lvCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editTask(i);
            }
        });

        alSchedules.add("19/02/2021 09:00 AM");
        alSchedules.add("19/02/2021 10:00 AM");

        adapterSchedules = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alSchedules);
        lvSchedules.setAdapter(adapterSchedules);

        alSubjects.add("Physics");
        alSubjects.add("Chemistry");
        alSubjects.add("Maths");

        adapterSubjects = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alSubjects);
        lvSubjects.setAdapter(adapterSubjects);

        lvSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "position="+i+" item="+ alSubjects.get(i), Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void editTask(int position){
        Intent i = new Intent(getApplicationContext(), NewTaskForm.class);

        // get the contents of the task at position
        TaskModel t = myTasks.getMyTasksList().get(position);
        i.putExtra("position", position);
        i.putExtra("name", t.getSubName());
        i.putExtra("time", t.getTaskTime());
        i.putExtra("day", t.getTaskDay());
        i.putExtra("date", t.getTaskDate());

        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        MenuItem mSearch = menu.findItem(R.id.menu_search);
        SearchView mSearchView = (SearchView)mSearch.getActionView();
        mSearchView.setQueryHint("Search your schedule");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterSubjects.getFilter().filter(newText);

                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    

    public void addSubject(){
        Toast.makeText(this, "Custom Dialog alert will open", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Add a new subject");
        EditText subject = new EditText(this);
        subject.setInputType(InputType.TYPE_CLASS_TEXT);
        mydialog.setView(subject);

        mydialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String subjectName = subject.getText().toString();
                if (!subjectName.isEmpty()) {
                    alSubjects.add(subjectName);
                    Collections.sort(alSubjects); // sorting list
                    adapterSubjects.notifyDataSetChanged(); // notify adapter that changes has occured
                    Toast.makeText(MainActivity.this, "new Subject added above " + subjectName, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Must provide a subject name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "negative int i" + i, Toast.LENGTH_SHORT).show();

                    }
                });

        mydialog.show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        String msg="Option menu";
        switch (id){
            case R.id.menu_search:
                msg="Search";
                break;
            case R.id.menu_addSchedule:
                msg ="add Schedule";
                Intent intent = new Intent(MainActivity.this, NewTaskForm.class);
                intent.putExtra("position", -1);
                startActivity(intent);
                break;
            case R.id.menu_mySubjects:
                msg="my subjects";
                break;

            case R.id.menu_addSubject:
                msg="add a subject";
                addSubject();
                break;

            default:
                msg="none option menu selected";
                break;

        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();


        return super.onOptionsItemSelected(item);
    }

}