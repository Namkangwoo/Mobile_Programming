package com.example.user.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView=(TextView)findViewById(R.id.txt);
        goBtn=(Button)findViewById(R.id.gobtn);
        backBtn=(Button)findViewById(R.id.backbtn);


        final Intent passedIntent=getIntent(); //Get intent and store
        Bundle myBundle = passedIntent.getExtras();
        final String passedUrl = myBundle.getString("url");
        textView.setText(passedUrl);
        /*
        description : when 'goBtn' button is clicked, Check the 'passedUrl'.
                      If passed Url is not inputed, print toast message.
                      Else, execute the URL using browser.
        input : view object
        output: none
        */
        goBtn.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view) {
                if (!passedUrl.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://m." + passedUrl));
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해 주세요", Toast.LENGTH_LONG).show();
                }
            }
        });
/*
        description : when 'backBtn' button is clicked, print toast message.
                      Then finish the activity and return to previous activity.
        input : view object
        output: none
        */
        backBtn.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다", Toast.LENGTH_LONG).show();
                    finish();
            }
        });
    }
}
