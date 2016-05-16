package com.example.asus.piano;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ASUS on 5/15/2016.
 */
public class Piano extends View {
    TextView coba = (TextView)findViewById(R.id.piano_textView);
    public Piano(Context context){
        super(context);
    }
    public Piano(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public Piano(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    Bitmap whiteKey, blackKey;
    Paint paint =new Paint();

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int desireWidth=1000;
        int desireHeight=300;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }
        else if (widthMode == MeasureSpec.AT_MOST){
            width = Math.min(desireWidth,widthSize);
        }
        else{
            width = desireWidth;
        }

        if (heightMode==MeasureSpec.EXACTLY){
            height = heightSize;
        }
        else if (heightMode == MeasureSpec.AT_MOST){
            height = Math.min(desireHeight,heightSize);
        }
        else {
            height = desireHeight;
        }
        setMeasuredDimension(width,height);
    }

    public void draw(Canvas canvas){

        if (whiteKey == null){
            whiteKey = BitmapFactory.decodeResource(getResources(), R.drawable.pianokeyswhite);
        }
        if (blackKey == null){
            blackKey = BitmapFactory.decodeResource(getResources(),R.drawable.pianokeysblack);
        }
        int keys = 13;
        int i = 0;
        for (; i < keys ;i++) {
            canvas.drawBitmap(whiteKey, i * whiteKey.getWidth(), 0, paint);
            if (i==1){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 0.3f, 0, paint);
            }

            else if (i==2){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 0.9f, 0, paint);
            }

            else if (i==4){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 2.2f, 0, paint);
            }

            else if (i==5){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 2.9f, 0, paint);
            }

            else if (i==6){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 3.6f, 0, paint);
            }

            else if (i==8){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 4.9f, 0, paint);
            }

            else if (i==9){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 5.6f, 0, paint);
            }

            else if (i==11){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 6.9f, 0, paint);
            }

            else if (i==12){
                canvas.drawBitmap(blackKey, i * blackKey.getWidth() + blackKey.getWidth() * 7.6f, 0, paint);
            }
            }
        }
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            if (x >= 70 && x < (70+whiteKey.getWidth()) && y >= 70 && y < (70+whiteKey.getHeight())){
                coba.setText("TESSSSSSS");
            }
                break;
        }
        return false;
    }
    };
