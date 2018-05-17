package com.example.user.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText inputText;
    TextView numText;
    TextView resultText;
    int num,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        inputText = (EditText) findViewById(R.id.inputText);
        numText = (TextView) findViewById(R.id.numberText);
        resultText = (TextView) findViewById(R.id.resultText);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new CountDownTask().execute(); //create AsyncTask
            }
        });
    }

    private class CountDownTask extends AsyncTask<Void, Integer, Void> {

        @Override
        /*
        description : initialize TextViews and store the inputed data
        input: none
        output: none
         */
        protected void onPreExecute() {
            result=1;
            numText.setText("");
            resultText.setText("");
            num=Integer.parseInt(inputText.getText().toString());
        }

        /*
        description : perform factorial calculation
        input: void
        output: none
         */
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = num; i >= 1; i--) {
                try {
                    result*=i;
                    Thread.sleep(500);
                    publishProgress(i);
                } catch (Exception e) {
                }
            }
            return null;
        }

        /*
        description : append the number to TextView
        input: Integer
        output: none
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            numText.append(Integer.toString(values[0].intValue())+" ");
        }

        /*
        description : When finishing, print the result
        input: void
        output: none
         */
        @Override
        protected void onPostExecute(Void aVoid) {
            resultText.setText("= "+result);
        }
    }
}

