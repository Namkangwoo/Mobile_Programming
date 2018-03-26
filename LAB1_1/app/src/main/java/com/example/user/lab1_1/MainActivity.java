package com.example.user.lab1_1;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

        import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int ImageIdx=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencing the view object
        imageView =(ImageView)findViewById(R.id.img1);
        imageView2 =(ImageView)findViewById(R.id.img2);
    }

    /*
    description : When Button is clicked, increase ImageIdx and call the changeImage() function
    input : view object
    output: none
     */
    public void onButton1Clicked(View v)
    {
        ImageIdx++;
        changeImage();
    }

    /*
    description : Change the image according to ImageIdx(odd or even)
    input : none
    output: none
         */
    private void changeImage(){
        if(ImageIdx%2==0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

        }
        else if(ImageIdx%2==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }
    }

}
