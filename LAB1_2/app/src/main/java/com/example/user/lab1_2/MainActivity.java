package com.example.user.lab1_2;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public EditText edit_name;
    public Button btn_clear;
    public Button btn_print;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    /*
    description : referencing views
    input : none
    output: none
     */
    public void init(){
        edit_name=(EditText)findViewById(R.id.editName);
        btn_clear=(Button)findViewById(R.id.clear);
        btn_print=(Button)findViewById(R.id.print);
        view_print=(TextView)findViewById(R.id.txt);
    }

    /*
        description : when 'Clear' button is clicked, initialize  values;
        input : view object
        output: none
     */
    public void clearClicked(View v){
        edit_name.setText("");
        view_print.setText("");
    }

    /*
       description : when 'Print' button is clicked,
                     set the Textview to the text that is entered by user;
       input : view object
       output: none
    */
    public void printClicked(View v){
        String text=edit_name.getText().toString();
        view_print.setText(text);
    }
}
