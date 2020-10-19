package com.example.unit5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class BirthdayGuess extends AppCompatActivity {
    EditText date;

    Random number;
    int rNummber;
    String rnum;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_guess);
        date=findViewById(R.id.guessDate);




    }

    public void guessDate(View view){
        number= new Random();
        rNummber=number.nextInt(31);
        rnum=Integer.toString(rNummber);
        int input=Integer.parseInt( date.getText().toString());

        if (input<rNummber){
            showToat("Try Higher, the no. was "+rnum);
            count+=1;
        }else if (input>rNummber){
            showToat("Try Lower, the no was "+rnum);
            count+=1;
        }
        else{
            showToat("You guessed it correct in :"+Integer.toString(count)+" attempts");
            count=1;
        }

    }

    public void showToat(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}