package com.example.unitone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class P2LinearLayoutDemo extends AppCompatActivity implements View.OnClickListener {
    Button clearbtn, submitbtn, cancelledbtn;

    EditText name, regno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_linear_layout_demo);

        name=findViewById(R.id.NameInput);
        regno=findViewById(R.id.RegNoInput);

        name.setOnClickListener(this);
        regno.setOnClickListener(this);

        clearbtn=findViewById(R.id.ClearButton);
        submitbtn=findViewById(R.id.SubmitButton);
        cancelledbtn=findViewById(R.id.CancelledButton);

        clearbtn.setOnClickListener(this);
        submitbtn.setOnClickListener(this);
        cancelledbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String userName = name.getText().toString();
        String regnum=regno.getText().toString();

        switch (view.getId()){
            case R.id.ClearButton:
                //System.out.println("Clear Button clicked");
                // we can use any of these method to clear input texts
                if (userName.isEmpty() && regnum.isEmpty()){
                    toast("Nothing to clear");
                }
                else if (!userName.isEmpty() && !regnum.isEmpty()){
                    name.getText().clear();
                    regno.setText("");
                    toast("Cleared");
                }
                else if (!userName.isEmpty()){
                    name.getText().clear();
                toast("Name Cleared");}
                else if(!regnum.isEmpty()){
                    regno.setText("");
                    toast("Registration Number cleared");
                }
                break;

            case R.id.SubmitButton:
                System.out.println("Submit Button clicked");

                if (userName.isEmpty() || regnum.isEmpty()){
                    toast("Provide all the required details above");
                }else{
                toast("Submitted successfully");}
                break;
            case R.id.CancelledButton:
                System.out.println("Cancelled Button clicked");
                toast("Cancelled");
                break;
        }
    }
    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}