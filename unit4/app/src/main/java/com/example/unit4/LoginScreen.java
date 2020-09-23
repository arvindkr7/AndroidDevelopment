package com.example.unit4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
EditText uname, upass,nam;
Button submit;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        uname=findViewById(R.id.UName);
        nam=findViewById(R.id.Name);
        upass=findViewById(R.id.UPass);
        submit=findViewById(R.id.Submit);
    }

    public void Verify(View view){
        String id=uname.getText().toString();
        String pd=upass.getText().toString();
        String name= uname.getText().toString();

        if(id.equals("ag30982") && pd.equals("12345")){

            Intent i=new Intent(this, MainActivity.class);
            String msg= "Hello, "+name+". Your id is "+id;
            i.putExtra("name", msg);
            startActivity(i);
        }

    }


}