package com.example.ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText txtUserEmail, txtPassword;
    String toastMsg;
    // validation

    String emailregex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    boolean isemail=false, ispass=false;
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
        setTitle(R.string.sign_in);
        setContentView(R.layout.activity_main);
        txtUserEmail=findViewById(R.id.inputUserEmail);
        txtPassword=findViewById(R.id.inputPassword);
    }

    public void verify(View view){
        String email= txtUserEmail.getText().toString();
        String password=txtPassword.getText().toString();
        if (isValidEmail(email) && isValidPassword(password)){

        if (email.equals("ag30982@gmail.com") && password.matches("Demo@123")){
            showToast("Login Successful");
            Intent intent=new Intent(this, welcome.class);
            intent.putExtra("userEmail",email);
            startActivity(intent);
        }else{

            Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_LONG).show();
        }

        }

    }

    // Function to validate the password.
    protected boolean
    isValidPassword(String password)
    {



        // If the password is empty
        // return false
        if (password.isEmpty()) {
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
            showToast("Password doesn't meet the standard regulation");
        }


        return ispass;
    }
    // Function to validate the E-mail address.
    protected boolean isValidEmail(String id){

        if (id.isEmpty()){

            showToast("provide email address first");
            return false;
        }
        isemail= id.matches(emailregex);
        if (!isemail){
            showToast("invalid email address");
        }


        return isemail;


    }

    protected  void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}