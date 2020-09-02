package com.example.unitthree;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class listViewRes extends AppCompatActivity {
ListView lv;
Button btn;
int count=1;
int colors[]={Color.WHITE, Color.RED, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.DKGRAY, Color.GRAY, Color.MAGENTA, Color.LTGRAY};
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_res);
        lv=findViewById(R.id.lv);
        btn=findViewById(R.id.btnChange);

        ArrayAdapter al= ArrayAdapter.createFromResource(this, R.array.subjects, android.R.layout.simple_expandable_list_item_1);
        lv.setAdapter(al);
    }

    public void Change(View view) {
        lv=findViewById(R.id.lv);
        lv.setBackgroundColor(colors[count]);
        count+=1;
        switch (count%2){
            case 0:
                 ArrayAdapter ap= ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_expandable_list_item_1);
                lv.setAdapter(ap);
                 break;
            case 1:
                ArrayAdapter aa= ArrayAdapter.createFromResource(this, R.array.subjects, android.R.layout.simple_expandable_list_item_1);
                lv.setAdapter(aa);
                break;
        }
        count%=colors.length;
    }
}