package com.example.android_cse224;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P38HwActivity1 extends AppCompatActivity {
    EditText uemail, upass;
    CheckBox forgot;
    Button submit, change;
    String email, pswrd, updtdPswrd;
    String emailregex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    boolean isemail = false, ispass;
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
        setContentView(R.layout.activity_p38_hw1);

        uemail = findViewById(R.id.edtEmail);
        upass = findViewById(R.id.edtPassword);
        forgot = findViewById(R.id.chkForgotPassword);
        submit = findViewById(R.id.btnSubmit);
        change = findViewById(R.id.btnChange);

        forgot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (forgot.isChecked()) {
                    email = uemail.getText().toString();
                    if (isValidEmail(email)) {
                        Intent i = new Intent(getApplicationContext(), P34SetNewPassword.class);
                        startActivity(i);
                    }
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pswrd = upass.getText().toString();
                email = uemail.getText().toString();
                if (isValidEmail(email) && isValidPassword(pswrd)) {
                    showToast("Login successful");
                }
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(P38HwActivity1.this);
                builder.setTitle("Change Password");
                builder.setMessage("Are you sure?");
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(), "No is clicked", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(getApplicationContext(), "Yes is clicked", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), P34SetNewPassword.class);
                                startActivity(i);
                            }
                        });
                builder.setNeutralButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(getApplicationContext(), "Cancel is clicked", Toast.LENGTH_LONG).show();
                            }
                        });

                builder.show();
            }
        });
    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected boolean isValidPassword(String password) {
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
        ispass = m.matches();
        if (!ispass) {
            showToast("invalid password");
        }

        return ispass;
    }

    protected boolean isValidEmail(String id) {
        if (id.isEmpty()) {
            showToast("provide email address first");
            isemail = false;
        }
        isemail = id.matches(emailregex);
        if (!isemail) {
            showToast("invalid email address");
        }
        return isemail;
    }
}