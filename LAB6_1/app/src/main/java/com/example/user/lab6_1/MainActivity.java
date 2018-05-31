package com.example.user.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private final String fileName = "text.txt";
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView txtView;

    File sdCard;
    File directory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        txtView = (TextView) findViewById(R.id.txtData);

        sdCard = Environment.getExternalStorageDirectory();
        directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
        directory.mkdirs();

        /*
        description : When button is clicked, Write the text in the EditText to External storage
        input : OnclickListener
        output: none
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File file = new File(directory, fileName);
                FileOutputStream fOut = null;
                try {
                    fOut = new FileOutputStream(file);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                OutputStreamWriter osw = new OutputStreamWriter(fOut);
                try {
                    osw.write(txtView.getText().toString());
                    Toast.makeText(getApplicationContext(), "Done writing SD " + fileName, Toast.LENGTH_SHORT).show();
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
        description : When button is clicked, Clear the EditText View
        input : OnclickListener
        output: none
         */
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtView.setText("");
            }
        });

        /*
        description : When button is clicked, read from External storage and set text in the EditText
        input : OnclickListener
        output: none
         */
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File file = new File(directory, fileName);
                FileInputStream fIn = null;
                try {
                    fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    if (fIn != null) {
                        BufferedReader reader = new BufferedReader(isr);
                        String str = "";
                        StringBuffer buf = new StringBuffer();

                        while ((str = reader.readLine()) != null) {
                            buf.append(str + "\n");
                        }
                        fIn.close();
                        txtView.setText(buf.toString());
                        Toast.makeText(getApplicationContext(), "Done Reading SD " + fileName, Toast.LENGTH_SHORT).show();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        /*
        description : When button is clicked, finish the app
        input : OnclickListener
        output: none
         */
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
