package com.example.tms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText edtSubjectName;
    Button btnAddSubject;
    ListView lvSubjects;
    ArrayList<String> alSubjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        edtSubjectName = findViewById(R.id.edt_add_subject);
        btnAddSubject = findViewById(R.id.btn_add_subject);
        lvSubjects = findViewById(R.id.lst_view_subjects);
        alSubjects = new ArrayList<>();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbarmenu, menu);
        return true;
    }

    public void addSubject(View view) {
        String text = edtSubjectName.getText().toString();

        if (!text.isEmpty()){
            alSubjects.add(text);
            ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alSubjects);
            lvSubjects.setAdapter(adapter);

            edtSubjectName.setText("");
        }
        else{
            Toast.makeText(this,"MUST PROVIDE SUBJECT NAME", Toast.LENGTH_LONG).show();
        }

        }


    }