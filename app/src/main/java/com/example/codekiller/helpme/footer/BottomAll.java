package com.example.codekiller.helpme.footer;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.codekiller.helpme.PersonUI;
import com.example.codekiller.helpme.R;

public class BottomAll extends LinearLayout{
    public BottomAll(final Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_all, this);
        Button button1 =  findViewById(R.id.BottomButton1);
        Button button2 =  findViewById(R.id.BottomButton2);
        Button button3 =  findViewById(R.id.BottomButton3);
        Button button4 =  findViewById(R.id.BottomButton4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getContext(),PersonUI.class);
                context.startActivity(intent);
            }
        });


    }
}
