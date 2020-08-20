package com.example.unitone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.CheckBox;
import android.widget.TextView;

import static com.example.unitone.R.*;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_sign_up);

        TextView textView= findViewById(id.statement);
        String text = "I accept the Terms of Use & Privacy Policy";

        SpannableStringBuilder ssb = new SpannableStringBuilder(text);

        ForegroundColorSpan fcs= new ForegroundColorSpan(getResources().getColor(color.skyBlue));

        ssb.setSpan(fcs, 13,25, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        ssb.setSpan(fcs, 28, 42, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ssb);


    }
}