package com.example.unit4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class actionBarDemo extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menubar, menu);

        MenuItem search=menu.findItem(R.id.search);
        SearchView sv=(SearchView) search.getActionView();
        sv.setQueryHint("Enter anything to search");

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                customToast(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                customToast(s);
                return false;
            }
        });

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_demo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.copy:
                customToast("Copy button clicked");
                return true;


            case R.id.share:
                customToast("Share button clicked");
                return true;

            case R.id.more:
                customToast("more button clicked");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void customToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}