package com.example.user.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String SN, Name;
    Button readBtn;
    Button writeBtn;
    Button initBtn;
    EditText sn;
    EditText name;

    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readBtn = (Button) findViewById(R.id.read);
        writeBtn = (Button) findViewById(R.id.write);
        initBtn = (Button) findViewById(R.id.init);
        sn = (EditText) findViewById(R.id.sn);
        name = (EditText) findViewById(R.id.name);

        /*
        description : When button is clicked, store the text in the SharedPreference variable
        input : OnclickListener
        output: none
         */
        writeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SN = sn.getText().toString();
                Name = name.getText().toString();
                sh_Pref = getSharedPreferences("Info", MODE_PRIVATE);
                toEdit = sh_Pref.edit();
                toEdit.putString("sn", SN);
                toEdit.putString("name", Name);
                toEdit.commit();
            }
        });

        /*
        description : When button is clicked, read the data in the SharedPreference variable and set text in the EditTextView.
        input : OnclickListener
        output: none
         */
        readBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sh_Pref = getSharedPreferences("Info", MODE_PRIVATE);
                if (sh_Pref != null) {
                    String tempSN = sh_Pref.getString("sn", "");
                    String tempName = sh_Pref.getString("name", "");
                    sn.setText(tempSN);
                    name.setText(tempName);
                }
            }
        });

        /*
        description : When button is clicked, Clear the editTextView.
        input : OnclickListener
        output: none
         */
        initBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sn.setText("");
                name.setText("");
            }
        });
    }
}
