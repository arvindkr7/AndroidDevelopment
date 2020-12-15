package com.example.android_cse224;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class P16Form2 extends AppCompatActivity {
    EditText name, phone;
    ImageButton img_btn;
    boolean image_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p16_form2);

        name = findViewById(R.id.user_name);
        phone = findViewById(R.id.user_phone);
        Button btn = findViewById(R.id.submit_btn);
        img_btn = findViewById(R.id.user_image);
        image_upload = false;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate_form())
                    Toast.makeText(getApplicationContext(), "Form Submitted!", Toast.LENGTH_SHORT).show();
                else
                    Snackbar.make(findViewById(R.id.ll), "Fill all Fields!", Snackbar.LENGTH_LONG).setAction("Retry!", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(findViewById(R.id.ll), "Ok! Let's try again.", Snackbar.LENGTH_SHORT).show();
                        }
                    }).show();
            }
        });

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_upload = true;
                img_btn.setImageResource(R.drawable.android3);
            }
        });
    }

    boolean validate_form() {
        if (TextUtils.isEmpty(name.getText().toString())
                || TextUtils.isEmpty(phone.getText().toString())
                || !image_upload)
            return false;
        if (phone.getText().toString().length() != 10)
            return false;
        return true;
    }
}