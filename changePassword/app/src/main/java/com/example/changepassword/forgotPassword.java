package com.example.changepassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class forgotPassword extends AppCompatActivity{
    EditText newPassword, cnfPassword;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Update Password");
        setContentView(R.layout.activity_forgot_password);
    }
}