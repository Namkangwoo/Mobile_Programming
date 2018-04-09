package com.example.user.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn);

         Name=(EditText)findViewById(R.id.editText1);
        Age=(EditText)findViewById(R.id.editText2);

        /*
        description : when 'btn' button is clicked, inputed string of EditText is stored.
                      Then, create a intent send to newActivity and start newActivity
        input : view object
        output: none
        */
        btn.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                String name=Name.getText().toString();
                String age=Age.getText().toString();

                Bundle myBundle=new Bundle(); //Send using Bundle
                myBundle.putString("loginName",name);
                myBundle.putString("loginAge",age);
                Intent intent=new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtras(myBundle);
                startActivity(intent);

                Name.setText(""); //initialize
                Age.setText("");
            }
        });
    }
}
