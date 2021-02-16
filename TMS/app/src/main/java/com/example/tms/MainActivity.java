package com.example.tms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtSubjectName;
    Button btnAddSubject;
    ListView lvSubjects;
    ArrayList<String> alSubjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSubjectName = findViewById(R.id.edt_add_subject);
        btnAddSubject = findViewById(R.id.btn_add_subject);
        lvSubjects = findViewById(R.id.lst_view_subjects);
        alSubjects = new ArrayList<>();
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
            Toast.makeText(this, "Must provide a subject name to add", Toast.LENGTH_SHORT).show();
        }
    }
}