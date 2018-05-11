package com.example.user.lab4_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        setContentView(vw);
    }

    class MyView extends View {
        Paint paint = new Paint(); //create paint
        Path path = new Path(); //create path

        //initialize
        public MyView(Context context) {
            super(context);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10f);
            paint.setColor(Color.BLUE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);
        }

        /*
        description: get the X, Y coordinate of user's input point
        input: event
        output: true or false
         */
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //When user presses the screen
                    path.moveTo(x, y);
                    break;
                case MotionEvent.ACTION_MOVE: //When user drags the screen
                    path.lineTo(x, y);
                    break;
                case MotionEvent.ACTION_UP: //When user take off from the screen
                    break;
            }
            invalidate();
            return true;
        }
    }

}
