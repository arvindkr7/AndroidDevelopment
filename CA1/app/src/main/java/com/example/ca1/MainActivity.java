package com.example.ca1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    ArrayList al;
    EditText name, age;
    CheckBox Music, Games, Novels;
    RadioGroup gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spin);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        Music=findViewById(R.id.Music);
        Games=findViewById(R.id.Games);
        Novels=findViewById(R.id.Novels);
        gender=findViewById(R.id.gender);
        al=new ArrayList();
        al.add("Music Type");
        al.add("Classic");
        al.add("Rock");
        al.add("Jazz");

        ArrayAdapter ap= new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, al);
        ap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ap);
    }
    public void login(View view){

        ArrayList response= new ArrayList();


        String uname=name.getText().toString();
        String uage=age.getText().toString();
        String musictype=sp.getSelectedItem().toString();
        boolean isMusicTypeSelected=musictype.matches(sp.getItemAtPosition(0).toString());
        boolean music=Music.isChecked();
        boolean games=Games.isChecked();
        boolean novels= Novels.isChecked();
        int radioButtonID = gender.getCheckedRadioButtonId();
        boolean isHobbySelected= (music || games || novels );
        if (uname.isEmpty() || uage.isEmpty() || isMusicTypeSelected || radioButtonID==-1 || !isHobbySelected){
            String errorMsg="Please provide your ";
            if(uname.isEmpty()){
                errorMsg+="Name";
            }else if (uage.isEmpty()){
                errorMsg+="Age";
            }else if (isMusicTypeSelected){
                errorMsg+="Music Type preference";
            }else if (!isHobbySelected){
                errorMsg+="Hobbies";
            }else if (radioButtonID== -1){
                errorMsg+="Gender";
            }
            makeToast(errorMsg);
        }else{
        response.add("Name: ".concat(uname));
        response.add("Age: ".concat(uage));
        response.add("Music type: ".concat(musictype));
        String hobbies="Hobbies: ";
        if (music)   {
        hobbies+= (Music.getText().toString());}

        if (games){
            hobbies+=(Games.getText().toString());
        }
        if (novels){
            hobbies+=(Novels.getText().toString());
        }
            response.add(hobbies);
        RadioButton radioButton = gender.findViewById(radioButtonID);

        String val =("\nGender: "+ radioButton.getText().toString());
        response.add(val);
//        makeToast("Submitted successfully");
           makeToast(response.toString());
        }



    }
    public void makeToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}