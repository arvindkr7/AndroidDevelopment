package com.example.android_cse224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class P23HwContactDialler extends AppCompatActivity {

    ListView contactInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p23_hw_contact_dialler);
        contactInfo = findViewById(R.id.contact_info);
        ArrayList phone_numbers = new ArrayList();
        final long lowerBound = 1000000000L;
        final long upperBound = 9999999999L;

        for (int i = 0; i < 100; i++) {
            long newNumber = lowerBound + (long) (Math.random() * (upperBound - lowerBound));
            phone_numbers.add(Long.toString(newNumber));
        }

        ArrayAdapter adp = new ArrayAdapter(this, R.layout.my_list_view, phone_numbers);
        contactInfo.setAdapter(adp);

        contactInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Intent intent = new Intent(Intent.ACTION_DIAL);
                // intent.setData(Uri.parse("tel:" + ((TextView)view).getText().toString()));
                // startActivity(intent);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + ((TextView)view).getText().toString()));
                startActivity(intent);
            }
        });
    }
}