package com.example.android_cse224;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class P34ChangePassword extends AppCompatActivity {
    final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText email, password;
    String mail = "xyz@mail.com";
    String pass = "12345678";
    CheckBox forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p34_change_password);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        forgetPassword = findViewById(R.id.forget_password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 12) {
            String[] arr = data.getStringArrayExtra("CREDENTIALS");
            mail = arr[0];
            pass = arr[1];
            forgetPassword.setChecked(false);
            Toast.makeText(getApplicationContext(), "Password Changed Successfully!\n" + mail + " : " + pass, Toast.LENGTH_SHORT).show();
        }
    }

    public void checkEmail(View view) {
        if (!forgetPassword.isChecked()) return;
        if ((email.getText().toString()).isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill E-mail before clicking!", Toast.LENGTH_SHORT).show();
            forgetPassword.setChecked(false);
        } else {
            if (!(email.getText().toString()).trim().matches(emailPattern)) {
                Toast.makeText(getApplicationContext(), "Please Use Valid Email!", Toast.LENGTH_SHORT).show();
                forgetPassword.setChecked(false);
            } else {
                Intent newPassword = new Intent(this, P34SetNewPassword.class);
                newPassword.putExtra("EMAIL", email.getText().toString());
                startActivityForResult(newPassword, 12);
            }
        }
    }

    public void login(View view) {
        if (mail.equals(email.getText().toString()) && pass.equals(password.getText().toString()))
            Toast.makeText(getApplicationContext(), "Successfully Logged in!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
    }
}