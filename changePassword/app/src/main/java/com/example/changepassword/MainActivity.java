package com.example.changepassword;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.*;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
EditText uemail, upass;
CheckBox forgot;
Button submit, change;
String email, pswrd, updtdPswrd;
String emailregex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
boolean isemail=false, ispass;
    // Regex to check valid password.
    String regex = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";

    // Compile the ReGex
    Pattern p = Pattern.compile(regex);
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent= getIntent();
        updtdPswrd=intent.getStringExtra("updatedPassword");

        uemail=findViewById(R.id.edtEmail);
        upass=findViewById(R.id.edtPassword);
        forgot=findViewById(R.id.chkForgotPassword);
        submit=findViewById(R.id.btnSubmit);
        change=findViewById(R.id.btnChange);


        forgot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (forgot.isChecked() ){
                    email= uemail.getText().toString();
                    if (isValidEmail(email)){

                  Intent i= new Intent(getApplicationContext(), forgotPassword.class);
                  startActivity(i);

                }

                }

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pswrd=upass.getText().toString();
                email=uemail.getText().toString();
                if (isValidEmail(email) && isValidPassword(pswrd)){
                    showToast("Login successful");
                }


            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);
                builder.setTitle("Change Password");
                builder.setMessage("Are you sure?");
                builder.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(getApplicationContext(),"No is clicked",Toast.LENGTH_LONG).show();
                            }
                        });
                builder.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
                                arrayAdapter.add("Alphabet");
                                arrayAdapter.add("Numeric");
                                arrayAdapter.add("Special Character");


                                Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                                Intent i= new Intent(getApplicationContext(), forgotPassword.class);
                                startActivity(i);
                            }
                        });
                builder.setNeutralButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(getApplicationContext(),"Cancel is clicked",Toast.LENGTH_LONG).show();
                            }
                        });

                builder.show();
            }
        });



    }
    protected void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    // Function to validate the password.
    protected boolean
    isValidPassword(String password)
    {



        // If the password is empty
        // return false
        if (password == null) {
            showToast("must provide your password");
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        ispass= m.matches();
        if (!ispass){
            showToast("invalid password");
        }


        return ispass;
    }

    protected boolean isValidEmail(String id){

        if (id.isEmpty()){

            showToast("provide email address first");
            isemail=false;
        }
        isemail= id.matches(emailregex);
        if (!isemail){
            showToast("invalid email address");
        }


        return isemail;


    }
}