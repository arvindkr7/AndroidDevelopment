package com.example.android_cse224;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class P34SetNewPassword extends AppCompatActivity {
    final char[] specialChars = {'!', '@', '#', '$', '%', '^', '&', '*', '.', '(', ')', '-', '_', '+', '='};
    EditText newPassword1, newPassword2;
    String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p34_set_new_password);

        newPassword1 = findViewById(R.id.new_password1);
        newPassword2 = findViewById(R.id.new_password2);

        mail = getIntent().getStringExtra("EMAIL");
    }

    private boolean checkSpecialChar(String s) {
        for (int i = 0; i < specialChars.length; i++) {
            if (s.indexOf(specialChars[i]) != -1)
                return true;
        }
        return false;
    }

    public void changePassword(View view) {
        String p1 = newPassword1.getText().toString();
        String p2 = newPassword2.getText().toString();
        if (p1.length() > 8 && checkSpecialChar(p1)) {
            if (p1.equals(p2)) {
                // Toast.makeText(getApplicationContext(), "Password Changed Successfully!", Toast.LENGTH_SHORT).show();
                String[] arr = {mail, p1};
                Intent intent = new Intent();
                intent.putExtra("CREDENTIALS", arr);
                setResult(12, intent);
                finish();
            } else
                Toast.makeText(getApplicationContext(), "Passwords don't match!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Weak Password!", Toast.LENGTH_SHORT).show();
    }
}