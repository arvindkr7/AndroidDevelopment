package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class P36AppChooser extends AppCompatActivity {
    EditText p, m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p36_app_chooser);

        p = findViewById(R.id.phone_no);
        m = findViewById(R.id.msg);
    }

    public void openBrowser(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        Intent chooser = Intent.createChooser(intent, "Choose Browser");
        startActivity(chooser);
    }

    public void sendMsg2(View view) {
         // Intent intent=new Intent(getApplicationContext(), P36AppChooser.class);
         // PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(p.getText().toString(), null, m.getText().toString(), null, null);
            Toast.makeText(getApplicationContext(), "Message sent!", Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Message couldn't be sent", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendMsg1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + p.getText().toString()));
        intent.putExtra("sms_body", m.getText().toString());
        startActivity(intent);
    }
}