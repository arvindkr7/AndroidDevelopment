package com.example.android_cse224;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;


// Can we call context menu on items of listview ?
// Create an android application which consists of list view of 5 minimum elements,.
// If you click on any of the items , A context menu should be displayed .
// The menu consist of item “ADD”, “delete” , “edit .
// If user select any item from menu then that particular action should be performed on that item .

public class P35ContextmenuOnListview extends AppCompatActivity {
    ListView listView;
    int list_item_index;
    ArrayAdapter<String> arrayAdapter;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p35_contextmenu_on_listview);

        String arr[] = {"A", "B", "C", "D"};
        // , "E", "F", "G", "H", "I", "J", "K"};
        arrayList = new ArrayList();
        Collections.addAll(arrayList, arr);

        listView = findViewById(R.id.list_items);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list_item_index = i;
                Toast.makeText(getApplicationContext(), "Long press" + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu2, menu);
        // menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(getApplicationContext(), "Add" + list_item_index, Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_item:
                Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_item:
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                arrayList.remove(list_item_index);
                arrayAdapter.notifyDataSetChanged();
                break;
        }
        return true;
    }

//    String openAddAlert() {
//        PopupMenu popupMenu = new PopupMenu(this, );
//
//    }
}