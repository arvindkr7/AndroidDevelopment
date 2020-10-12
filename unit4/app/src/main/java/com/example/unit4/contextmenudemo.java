package com.example.unit4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class contextmenudemo extends AppCompatActivity {
String streams[]={"cse", "it", "bba", "mba", "biotech"};
ListView lvt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextmenudemo);
        lvt=findViewById(R.id.contextlistview);

        ArrayAdapter<String> ap= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,streams);
        lvt.setAdapter(ap);

        // register the ListView for context menu

        registerForContextMenu(lvt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menubar, menu);
        menu.setHeaderTitle("Select the stream ...");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.share){
            Toast.makeText(this, "sharing", Toast.LENGTH_SHORT).show();

        }else{
            return false;
        }
        return true;
    }
}