package com.example.user.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent(); //Get intent and store
        if (passedIntent != null) {
            Bundle myBundle=passedIntent.getExtras();
            String loginName = myBundle.getString("loginName");
            String loginAge = myBundle.getString("loginAge");
            Toast.makeText(getApplicationContext(), "Student info: "+loginName+", "+loginAge, Toast.LENGTH_LONG).show(); //print toast message
        }

        Button btn = (Button) findViewById(R.id.new_btn);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish(); //finish the activity and return to previous activity
            }
        });
    }
}
