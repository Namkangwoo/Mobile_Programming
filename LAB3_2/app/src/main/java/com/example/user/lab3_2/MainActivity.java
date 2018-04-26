package com.example.user.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText nametxt;
    RadioGroup radGender;
    RadioButton radMan;
    RadioButton radWoman;
    CheckBox checkSMS;
    CheckBox checkEmail;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt=(EditText)findViewById(R.id.editText);
        radGender=(RadioGroup)findViewById(R.id.gender);
        radMan=(RadioButton)findViewById(R.id.man);
        radWoman=(RadioButton)findViewById(R.id.woman);
        checkSMS=(CheckBox)findViewById(R.id.chkSMS);
        checkEmail=(CheckBox)findViewById(R.id.chkEmail);
        btn=(Button)findViewById(R.id.btn);


        /*
        description : When button is clicked, find the selected radioButton and check box.
                      Then, send to other activity using bundle and intent.
        input : View
        output: none
         */
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getApplicationContext(),new_Activity.class);
        Bundle bundle=new Bundle();
        String gender="";
        String send="";
        int radioId=radGender.getCheckedRadioButtonId();
        if(radioId==radMan.getId()) {
            gender = "남";
            radMan.setChecked(false);
        }
        else if(radioId==radWoman.getId()) {
            gender = "여";
            radWoman.setChecked(false);
        }
        if(checkSMS.isChecked()) {
            send += "SMS ";
            checkSMS.setChecked(false);
        }
        if(checkEmail.isChecked()) {
            send += "Email ";
            checkEmail.setChecked(false);
        }

        bundle.putString("name",nametxt.getText().toString());
        bundle.putString("gender",gender);
        bundle.putString("send",send);
        intent.putExtras(bundle);
        startActivity(intent);

        nametxt.setText("");
    }
});

    }
}
