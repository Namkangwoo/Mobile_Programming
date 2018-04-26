package com.example.user.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class new_Activity extends AppCompatActivity {

    TextView nameTxt;
    TextView genderTxt;
    TextView sendTxt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_);

        nameTxt=(TextView)findViewById(R.id.nametxt);
        genderTxt=(TextView)findViewById(R.id.gendertxt);
        sendTxt=(TextView)findViewById(R.id.sendtxt);
        btn=(Button)findViewById(R.id.btn);

        //Get intent and bundle, then set the text to gotton data
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        nameTxt.setText(bundle.getString("name"));
        genderTxt.setText(bundle.getString("gender"));
        sendTxt.setText(bundle.getString("send"));

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //initialize
        nameTxt.setText("");
        genderTxt.setText("");
        sendTxt.setText("");
        finish();
    }
});

    }
}
