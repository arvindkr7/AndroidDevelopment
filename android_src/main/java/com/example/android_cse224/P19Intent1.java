package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class P19Intent1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p19_intent1);
    }

    public void perform(View v) {
        String uname = ((TextView) findViewById(R.id.editTextTextPersonName2)).getText().toString();
        String pass = ((TextView) findViewById(R.id.editTextTextPassword3)).getText().toString();
        System.out.println(uname + "  " + pass);
        if (!uname.isEmpty() && uname.equals(pass))
        {
            Intent i = new Intent(this, P19Intent2.class);
            i.putExtra("uname", uname);
            i.putExtra("pass", pass);
            startActivity(i);
        }
        else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
        }
    }

    public void go_signup(View v) {
        Intent i = new Intent(this, P6HwSignupForm.class);
        startActivity(i);
    }
}