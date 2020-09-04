package com.example.ca1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    CheckBox hobby1, hobby2, hobby3;
    RadioGroup gender;

    Button submit, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spin);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        hobby1=findViewById(R.id.Hobby1);
        hobby2=findViewById(R.id.Hobby2);
        hobby3=findViewById(R.id.Hobby3);
        gender=findViewById(R.id.gender);

        submit=findViewById(R.id.submitBtn);
        cancel=findViewById(R.id.cancelBtn);
        al=new ArrayList();
        al.add("Music");
        al.add("Classical");
        al.add("Rock");
        al.add("Jazz");


        ArrayAdapter ap= new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, al);
        ap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ap);
submit.setEnabled(false);
        age.addTextChangedListener(new TextWatcher() {



            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {
                    String stAge=age.getText().toString();
                    if (stAge.isEmpty()){
                        makeToast("must provide your age");
                        submit.setEnabled(false);
                    }else if (Integer.valueOf(stAge)<18){
                        makeToast("age must be 18 or above");
                        submit.setEnabled(false);
                    }else if (Integer.valueOf(stAge)<105){
                        submit.setEnabled(true);
                        makeToast("age accepted");
                    }else{
                        makeToast("age should be up to 105");
                        submit.setEnabled(false);
                    }
            }
        });
    }
    public void login(View view){

        ArrayList response= new ArrayList();


        String uname=name.getText().toString();
        String uage=age.getText().toString();
        String musictype=sp.getSelectedItem().toString();
        boolean isMusicTypeSelected=musictype.matches(sp.getItemAtPosition(0).toString());
        boolean isHobby1=hobby1.isChecked();
        boolean isHobby2=hobby2.isChecked();
        boolean isHobby3= hobby3.isChecked();
        int radioButtonID = gender.getCheckedRadioButtonId();
        boolean isHobbySelected= (isHobby1 || isHobby2 || isHobby3);
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
        if (isHobby1)   {
        hobbies+= (hobby1.getText().toString());}

        if (isHobby2){
            hobbies+=(hobby2.getText().toString());
        }
        if (isHobby3){
            hobbies+=(hobby3.getText().toString());
        }
            response.add(hobbies);
        RadioButton radioButton = gender.findViewById(radioButtonID);

        String val =("\nGender: "+ radioButton.getText().toString());
        response.add(val);
        makeToast("Submitted the record");
//           makeToast(response.toString());
        }



    }

    public void setCancel(View view){
        name.setText(null);
        age.setText(null);
        sp.setSelection(0);
        hobby1.setChecked(false);
        hobby2.setChecked(false);
        hobby3.setChecked(false);
        gender.clearCheck();
        makeToast("Cancelled");
    }
    public void makeToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}