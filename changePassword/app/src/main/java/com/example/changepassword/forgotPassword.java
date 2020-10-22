package com.example.changepassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.*;



public class forgotPassword extends AppCompatActivity{
    EditText newPassword, cnfPassword;
    Button update;
    Boolean ismatched=false;
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
        setTitle("Update Password");
        setContentView(R.layout.activity_forgot_password);
        newPassword=findViewById(R.id.edtNewPassword);
        cnfPassword=findViewById(R.id.edtCnfPassword);
        update=findViewById(R.id.btnUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pswrd=newPassword.getText().toString();
                String cnfPswrd=cnfPassword.getText().toString();
                if (isValidPassword(pswrd) && isValidPassword(cnfPswrd)){
                    if(pswrd.matches(cnfPswrd)) {
                        Intent i = new Intent(forgotPassword.this, MainActivity.class);
                        i.putExtra("updatedPassword", cnfPswrd);
                        Toast.makeText(forgotPassword.this, "Password Updated", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(forgotPassword.this, "Password doesn't macth", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    // Function to validate the password.
    protected boolean
    isValidPassword(String password)
    {



        // If the password is empty
        // return false
        if (password.isEmpty()) {
            Toast.makeText(this, "empty password", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        ismatched= m.matches();
        if(!ismatched){
            Toast.makeText(this, "doesn't certify the pattern", Toast.LENGTH_SHORT).show();
        }

        return  ismatched;
    }
}