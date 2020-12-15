package com.example.android_cse224;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class P7RadioAndCheckbox_QuickSurvey extends AppCompatActivity {
    EditText first_name, last_name, user_id;
    RadioButton[] gender;
    CheckBox[] prog_lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7_radio_and_checkbox);

        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        user_id = (EditText) findViewById(R.id.user_id);
        prog_lang = new CheckBox[4];
        prog_lang[0] = (CheckBox) findViewById(R.id.prog_lang_cpp);
        prog_lang[1] = (CheckBox) findViewById(R.id.prog_lang_py);
        prog_lang[2] = (CheckBox) findViewById(R.id.prog_lang_java);
        prog_lang[3] = (CheckBox) findViewById(R.id.prog_lang_go);
        gender = new RadioButton[3];
        gender[0] = (RadioButton) findViewById(R.id.gender_male);
        gender[1] = (RadioButton) findViewById(R.id.gender_female);
        gender[2] = (RadioButton) findViewById(R.id.gender_other);
    }

    private boolean formIsValid() {
        if (TextUtils.isEmpty(first_name.getText()) || TextUtils.isEmpty(last_name.getText())) {
            Toast.makeText(getApplicationContext(), "Name Field is empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(user_id.getText())) {
            Toast.makeText(getApplicationContext(), "User Id Field is empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (user_id.length() > 5) {
            Toast.makeText(getApplicationContext(), "ID Field is more than 5 digit!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!gender[0].isChecked() && !gender[1].isChecked() && !gender[2].isChecked()) {
            Toast.makeText(getApplicationContext(), "Gender Field is empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void formSubmit(View view) {
        if (formIsValid()) {
            String form_details = "Form Submitted!\n\n";
            form_details += "Name: " + first_name.getText() + " " + last_name.getText() + '\n';
            form_details += "ID: " + user_id.getText() + '\n';
            form_details += "Gender: " + (gender[0].isChecked() ? "Male" : gender[1].isChecked() ? "Female" : "Other") + "\n\n";
            form_details += "Preferred Languages: "
                    + (prog_lang[0].isChecked() ? " C++ " : "")
                    + (prog_lang[1].isChecked() ? " Python " : "")
                    + (prog_lang[2].isChecked() ? " Java " : "")
                    + (prog_lang[3].isChecked() ? " Go " : "");

            Toast form_toast = Toast.makeText(getApplicationContext(), form_details, Toast.LENGTH_SHORT);
            form_toast.show();
        }
        System.out.println("Your Form successfully submitted!");
    }
}