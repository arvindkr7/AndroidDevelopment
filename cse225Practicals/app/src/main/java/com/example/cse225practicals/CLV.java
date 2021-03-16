package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CLV extends AppCompatActivity {

    ListView lv;

    String[] persons= {"Arvind", "kumar"};
    String[] positions = {"ceo", "coo"};
    String[] salaries = {"100", "150"};
    int[] images={R.drawable.ic_launcher_foreground, R.drawable.ic_baseline_text_format_24};

    ClvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clv);

        lv = findViewById(R.id.clv);

        adapter = new ClvAdapter(this);
        lv.setAdapter(adapter);


    }

    class ClvAdapter extends BaseAdapter{

        Context context;

        public ClvAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return persons.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = LayoutInflater.from(context).inflate(R.layout.clvlayout, viewGroup, false);

            TextView tvName = view.findViewById(R.id.tv_name_clvLayout);
            TextView tvPosition = view.findViewById(R.id.tv_position_clvLayout);
            TextView tvSalary = view.findViewById(R.id.tv_salary_clvLayout);
            ImageView imageView = view.findViewById(R.id.iv_image_clvLayout);
            tvName.setText(persons[i]);
            tvPosition.setText(positions[i]);
            tvSalary.setText(salaries[i]);
            imageView.setImageResource(images[i]);
            return view;


        }
    }
}