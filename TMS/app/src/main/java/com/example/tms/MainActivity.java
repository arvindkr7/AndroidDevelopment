package com.example.tms;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSchedules, lvSubjects;
    Toolbar  toolbar;
    ArrayAdapter adapterSchedules, adapterSubjects;
    ArrayList <String> alSchedules = new ArrayList<String>();
    ArrayList<String> alSubjects = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSchedules = findViewById(R.id.lv_Schedules);
        lvSubjects = findViewById(R.id.lv_Subjects);
        toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        alSchedules.add("19/02/2021 09:00 AM");
        alSchedules.add("19/02/2021 10:00 AM");

        adapterSchedules = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alSchedules);
        lvSchedules.setAdapter(adapterSchedules);

        alSubjects.add("Physics");
        alSubjects.add("Chemistry");
        alSubjects.add("Maths");

        adapterSubjects = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alSubjects){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // get current item
                View view = super.getView(position, convertView, parent);
                if (position%2==0){
                    view.setBackground(getResources().getDrawable(R.drawable.custom_listview_card));
                }

                else{
                        view.setBackground(getResources().getDrawable(R.drawable.custom_listview_bottom_card));
                }
                return view;
            }
        };
        lvSubjects.setAdapter(adapterSubjects);


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
                msg ="add scedule";
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