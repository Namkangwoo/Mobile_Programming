package com.example.user.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler(); //create handler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        /*
        description: when button is clicked, create and start two threads
        input: OnclickListener
        output: none
         */
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                DogThread thr1 = new DogThread(0);
                DogThread thr2 = new DogThread(1);
                thr1.start();
                thr2.start();
            }
        });
    }

    class DogThread extends Thread {

        int stateIndex;
        int dogIndex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        //constructor that add three images
        public DogThread(int index) {
            dogIndex = index;
            images.add(R.drawable.dog_one);
            images.add(R.drawable.dog_two);
            images.add(R.drawable.dog_three);
        }

        /*
        description: change the images according to random time
        input: none
        output: none
         */

        public void run() {
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;
                handler.post(new Runnable() {
                    public void run() {
                        editText.append(msg + "\n");

                        if (dogIndex == 0) {
                            imageView1.setImageResource(images.get(stateIndex));
                        } else if (dogIndex == 1) {
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }
                });

                try {
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stateIndex++;
                if (stateIndex >= images.size()) {
                    stateIndex = 0;
                }
            }
        }

        public int getRandomTime(int min, int max) {
            return min + (int) (Math.random() * (max - min)); //set the random time
        }
    }
}