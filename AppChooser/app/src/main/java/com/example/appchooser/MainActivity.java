package com.example.appchooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNumber, edtMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber=findViewById(R.id.edtNumber);
        edtMessage=findViewById(R.id.edtMessage);
        btnSend=findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMS(view);
            }
        });
    }

    public  void Browser(View view){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.com"));
        Intent chooser= Intent.createChooser(i, "Open Browser");
        startActivity(chooser);
        //startActivity(i);
    }

    public  void SMS(View view){
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", "9910995297");
        smsIntent.putExtra("sms_body","Body of Message");
        startActivity(smsIntent);
    }
    protected void sendSMS(View view){
        String number=edtNumber.getText().toString().trim();
        String message=edtMessage.getText().toString().trim();

        if (number.isEmpty() || number.length()!=10 || number.startsWith("0")){
            showToast("Enter valid number");
        }else if (message.isEmpty()){
            showToast("empty message can't be sent");
        }else {

            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null, message, null, null);
                showToast("message sent");
            } catch (Exception e) {
                    showToast("Exception encountered "+e);
            }
        }
    }


    protected void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}