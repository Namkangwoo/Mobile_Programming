package com.example.user.lab3__3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FirstFragment ff;
    SecondFragment fs;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ff=new FirstFragment(); //create fragment object
        fs=new SecondFragment(); //create fragment object

        btn1=(Button)findViewById(R.id.btn_1);
        btn2=(Button)findViewById(R.id.btn_2);

        /*
        description : When this button is clicked, change fragment to Firstfragment
         input : none
         output : none
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_for_fragment,ff).commit();

            }
        });

        /*
        description : When this button is clicked, change fragment to Secondfragment
         input : none
         output : none
         */
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_for_fragment,fs).commit();

            }
        });
    }
}