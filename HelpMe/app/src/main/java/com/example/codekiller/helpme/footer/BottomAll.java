package com.example.codekiller.helpme.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.codekiller.helpme.R;

public class BottomAll extends LinearLayout{
    public BottomAll(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_all, this);
        Button button1 = (Button) findViewById(R.id.BottomButton1);
        Button button2 = (Button) findViewById(R.id.BottomButton2);
        Button button3 = (Button) findViewById(R.id.BottomButton3);
        Button button4 = (Button) findViewById(R.id.BottomButton4);


    }
}
