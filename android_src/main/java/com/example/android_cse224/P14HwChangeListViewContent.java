package com.example.android_cse224;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class P14HwChangeListViewContent extends AppCompatActivity {
    ListView lv;
    ArrayAdapter adp1, adp2;
    String[] s;
    boolean adp1_set = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p14_hw_change_list_view_content);

        lv = findViewById(R.id.subject_spinner);
        s = new String[4];
        s[0] = "1";
        s[1] = "2";
        s[2] = "3";
        s[3] = "4";
        adp1 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, s);
        adp2 = ArrayAdapter.createFromResource(this, R.array.subjects, android.R.layout.simple_expandable_list_item_1);
        lv.setAdapter(adp1);
        ((Button) findViewById(R.id.change_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adp1_set)
                    lv.setAdapter(adp2);
                else
                    lv.setAdapter(adp1);
                adp1_set = !adp1_set;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int index = 0; index < adapterView.getChildCount(); index++)
                    ((View) adapterView.getChildAt(index)).setBackgroundColor(0xffffffff);
                view.setBackgroundColor(0xffeeeeee);
                if (view.isSelected())
                    view.setBackgroundColor(0xff888888);
            }
        });
    }
}