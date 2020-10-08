package com.example.unit4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class menupopup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupopup);
    }
    public void PopClick(View view){
        PopupMenu popup=new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.menubar, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item){
                Toast.makeText(getApplicationContext(), " "+item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();

    }
}