package com.example.ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUserName, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.sign_in);
        setContentView(R.layout.activity_main);
        txtUserName=findViewById(R.id.inputUserName);
        txtPassword=findViewById(R.id.inputPassword);
    }

    public void verify(View view){
        String userName= txtUserName.getText().toString();
        String password=txtPassword.getText().toString();

        if (userName.equals("ag30982") && password.matches("12345")){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, welcome.class);
            intent.putExtra("userName",userName);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }
}