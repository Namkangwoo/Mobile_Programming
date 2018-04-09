package com.example.user.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url=(EditText)findViewById(R.id.editText1);
        nextBtn=(Button)findViewById(R.id.btn);

        /*
        description : when 'nextBtn' button is clicked, inputed URL of EditText is stored.
                      Then, create a intent send to newActivity and start newActivity
        input : view object
        output: none
        */
        nextBtn.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                String myUrl=Url.getText().toString();
                Intent intent=new Intent(getApplicationContext(),NewActivity.class);
                Bundle myBundle=new Bundle(); //Send using Bundle
                myBundle.putString("url",myUrl);
                intent.putExtras(myBundle);
                startActivity(intent);

                Url.setText("");
            }
        });
    }
}
