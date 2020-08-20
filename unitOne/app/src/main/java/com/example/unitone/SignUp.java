package com.example.unitone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.unitone.R.*;

public class SignUp extends AppCompatActivity {

    EditText fName, lName, emailId, pswrd, confirmPswrd;
    CheckBox agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_sign_up);



        fName=findViewById(id.firstName);
        lName=findViewById(id.lastName);
        emailId=findViewById(id.emailid);
        pswrd=findViewById(id.pasword);
        confirmPswrd=findViewById(id.confirmPassword);

        agree=findViewById(id.checkbox);


        TextView textView= findViewById(id.statement);
        String statement = "I accept the Terms of Use & Privacy Policy";

        SpannableString ss= new SpannableString(statement);

        ClickableSpan span1= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(SignUp.this, "You read Terms of Use", Toast.LENGTH_SHORT).show();
            }

        };

        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(SignUp.this, "You read Privacy Policy", Toast.LENGTH_SHORT).show();
            }
        };

        ss.setSpan(span1, statement.indexOf("Terms"), statement.indexOf("se")+2,  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, statement.indexOf("Privacy"), statement.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);

        textView.setMovementMethod(LinkMovementMethod.getInstance());


/*

        SpannableStringBuilder ssb = new SpannableStringBuilder(text);

        ForegroundColorSpan fcs= new ForegroundColorSpan(getResources().getColor(color.skyBlue));
        ForegroundColorSpan fcs2= new ForegroundColorSpan(getResources().getColor(color.skyBlue));

        ssb.setSpan(fcs, text.indexOf("Terms"),text.indexOf("se")+2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(fcs2, text.indexOf("Pri"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ssb);

 */


    }
    public  void submit(View view){

        String fname= fName.getText().toString();
        String lname=lName.getText().toString();
        String email= emailId.getText().toString();
        String password= pswrd.getText().toString();
        String confirmPassword= confirmPswrd.getText().toString();
        Boolean check= agree.isChecked();

        String msg="";

        if (fname.isEmpty() || lname.isEmpty()|| email.isEmpty()|| password.isEmpty() ||(password!=confirmPassword) || !check) {


            msg+="Kindly correct all the required details:";
            if(fname.isEmpty()){
                msg+="\nFirst Name";
            }
            if (lname.isEmpty()){
                msg+="\nLast Name";
            }
            if (email.isEmpty()){
                msg+= "\nEmail Address";
            }
            if(password.isEmpty() || confirmPassword.isEmpty()){
                msg+="\nYou must set your password";
            } else if (password != confirmPassword) {
                msg+= "\nPassword doesn't match!";
            }
        if (!check) {
                msg+="\nYou must agree first to continue!";
            }
        customToast(msg);
        }
        else{
            customToast("Signup successful");
        }
    }

    public void customToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}