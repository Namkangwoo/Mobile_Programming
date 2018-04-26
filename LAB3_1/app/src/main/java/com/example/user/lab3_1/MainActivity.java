package com.example.user.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button) findViewById(R.id.btn);
        registerForContextMenu(mBtn); //Register the view
    }

    /*
    description : When the registered view receives a long-click event,
                  the system calls this method
    input : Context menu, View, ContextMenuInfo
    output : none
     */
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");

        //add menu
        menu.add(0, 1, 0, "Red");
        menu.add(0, 2, 0, "Green");
        menu.add(0, 3, 0, "Blue");

    }

    /*
    description : When the user selects a menu item, the system calls this method
    input : MenuItem
    output : true ,false
     */
    public boolean onContextItemSelected(MenuItem item) {
        int cur=item.getItemId();
                if(cur==1)
                    mBtn.setTextColor(Color.RED);
        if(cur==2)
            mBtn.setTextColor(Color.GREEN);
        if(cur==3)
            mBtn.setTextColor(Color.BLUE);
        return super.onContextItemSelected(item);

    }
}
