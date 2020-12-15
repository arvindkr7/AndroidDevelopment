package com.example.android_cse224;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class P9ListView extends AppCompatActivity {
    RelativeLayout layout;
    ListView lv;
    ArrayList arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9_list_view);

        layout = (RelativeLayout) findViewById(R.id.layout_body);
        lv = (ListView) findViewById(R.id.lv1);
        arr = new ArrayList();
        arr.add("RED");
        arr.add("GREEN");
        arr.add("BLUE");
        arr.add("YELLOW");

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adp);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                view.setBackgroundColor(0xff000000);
                ((TextView) view).setTextColor(0xffffffff);
                switch (item) {
                    case "RED":
                        layout.setBackgroundColor(0xffff0000);
                        break;
                    case "GREEN":
                        layout.setBackgroundColor(Color.parseColor(item));
                        break;
                    case "BLUE":
                        layout.setBackgroundColor(Color.BLUE);
                        break;
                    case "YELLOW":
                        layout.setBackgroundColor(Color.YELLOW);
                        break;
                }
            }
        });
    }
}