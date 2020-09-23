package com.example.unitthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginScreen extends AppCompatActivity {
    EditText name,phone;

    Button submit;

    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        submit=findViewById(R.id.submit);
        img=findViewById(R.id.imgBtn);

        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
    }

    public void submit(View view){

        String Name=name.getText().toString();

        String Phone=phone.getText().toString();

        Boolean isNameValid=Name.isEmpty();
        Boolean isPhoneValid= Phone.length()!=10;
        if (isNameValid || isPhoneValid) {

            if (isNameValid) {
                toastAlert("Name can't be empty");
            }
            if (isPhoneValid) {
                snackAlert(view);
            }
        }else{
            toastAlert("Submitted");
        }


    }

    public void toastAlert(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }

    public void snackAlert(View view){
        Snackbar.make(view, "Phone is invalid", Snackbar.LENGTH_SHORT).show();
    }
}