package com.example.user.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    DBHelper helper;

    Button addBtn;
    Button deleteBtn;

    String[] info;
    EditText name;
    EditText sn;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(MainActivity.this, "student.db", null, 1);
        addBtn = (Button) findViewById(R.id.add);
        deleteBtn = (Button) findViewById(R.id.delete);
        name = (EditText) findViewById(R.id.name);
        sn = (EditText) findViewById(R.id.sn);
        listView = (ListView) findViewById(R.id.listView);

        /*
        description : When button is clicked, call add() function
        input : OnclickListener
        output: none
         */
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                add();
            }
        });

        /*
        description : When button is clicked, call delete() function
        input : OnclickListener
        output: none
         */
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                delete();
            }
        });
    }

        /*
        description : Add student information into database and Show the listView.
        input : none
        output: none
         */
    public void add() {
        String n = name.getText().toString();
        String s = sn.getText().toString();

        if (n.isEmpty() || s.isEmpty()) //Condition check
            Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_LONG).show();
        else {
            db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("name", n);
            values.put("sn", s);
            db.insert("student", null, values);

            db = helper.getReadableDatabase();
            Cursor c = db.query("student", null, null, null, null, null, null);

            info = new String[c.getCount()];
            int i = 0;
            while (c.moveToNext()) {
                info[i] = c.getString(c.getColumnIndex("name")) + "  " + c.getString(c.getColumnIndex("sn"));
                i++;
            }
            name.setText("");
            sn.setText("");
            c.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, info);
            listView.setAdapter(adapter);
        }
    }

    /*
       description : Delete student information from database and Show the listView.
       input : none
       output: none
     */
    public void delete() {
        String n = name.getText().toString();

        if (n.isEmpty()) //Condition check
            Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_LONG).show();
        else {
            db = helper.getWritableDatabase();
            db.delete("student", "name=?", new String[]{n});

            db = helper.getReadableDatabase();
            Cursor c = db.query("student", null, null, null, null, null, null);
            info = new String[c.getCount()];

            int i = 0;
            while (c.moveToNext()) {
                info[i] = c.getString(c.getColumnIndex("name")) + "  " + c.getString(c.getColumnIndex("sn"));
                Log.d("zzz", info[i]);
                i++;
            }

            name.setText("");
            sn.setText("");
            c.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, info);
            listView.setAdapter(adapter);
        }
    }
}



