package com.example.user.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button openBtn;
    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout); //Sliding layout
        openBtn = (Button) findViewById(R.id.btn_open);
        closeBtn = (Button) findViewById(R.id.btn_close);


        /*
        description: When button is clicked, Sliding Area appears with slide animation to the left.
        input: View
        output: none
         */
        openBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.leftslide);
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout.startAnimation(anim); //start animation
                openBtn.setVisibility(View.GONE);
                closeBtn.setVisibility(View.VISIBLE);
            }
        });

        /*
        description: When button is clicked, if the Sliding area is displayed,
                     the Sliding Area disappears with the slide animation to the right.
        input: View
        output: none
         */
        closeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Animation anim2 = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.rightslide);
                linearLayout.startAnimation(anim2); //start animation
                linearLayout.setVisibility(View.GONE);
                openBtn.setVisibility(View.VISIBLE);
                closeBtn.setVisibility(View.GONE);
            }
        });
    }
}
