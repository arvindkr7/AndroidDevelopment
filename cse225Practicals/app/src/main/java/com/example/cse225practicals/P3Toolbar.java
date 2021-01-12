package com.example.cse225practicals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

    public class P3Toolbar extends AppCompatActivity {
        ArrayAdapter ad;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_p3_toolbar);
            Toolbar tb=findViewById(R.id.tb1);
            setSupportActionBar(tb);
            ListView lv1 = findViewById(R.id.lv1);
            String course[]={"Physics","Physique","Philosophy" ,"Chemistry", "Maths"};
            ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,course);
            lv1.setAdapter(ad);



        }



        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.mymenu, menu);
            MenuItem mSearch = menu.findItem(R.id.search_bar);
            SearchView msv = (SearchView)mSearch.getActionView();
            msv.setQueryHint("Enter a course");
            msv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    ad.getFilter().filter(s);
                    return true;
                }
            });

            return super.onCreateOptionsMenu(menu);
        }




    }