package com.sharma.crorepathi;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ScoreDialog extends Dialog {
    TextView amount1;
    TextView amount2;
    TextView amount3;
    TextView amount4;
    TextView amount5;
    TextView amount6;
    TextView amount7;
    TextView amount8;
    TextView amount9;
    TextView amount10;
    TextView amount11;
    TextView amount12;
    TextView amount13;
    TextView amount14;
    TextView amount15;
    static  int iteration = 14;
    int[] amount = {
            R.id.TextView1,
            R.id.TextView2,
            R.id.TextView3,
            R.id.TextView4,
            R.id.TextView5,
            R.id.TextView6,
            R.id.TextView7,
            R.id.TextView8,
            R.id.TextView9,
            R.id.TextView10,
            R.id.TextView11,
            R.id.TextView12,
            R.id.TextView13,
            R.id.TextView14,
            R.id.TextView15,
    };


    public ScoreDialog(@NonNull Context context) {
        super(context);

        this.setContentView(R.layout.score);
      /*  amount1 = findViewById(R.id.TextView1);
        amount2 = findViewById(R.id.TextView2);
        amount3 = findViewById(R.id.TextView3);
        amount4 = findViewById(R.id.TextView4);
        amount5 = findViewById(R.id.TextView5);
        amount6 = findViewById(R.id.TextView6);
        amount7 = findViewById(R.id.TextView7);
        amount8 = findViewById(R.id.TextView8);
        amount9 = findViewById(R.id.TextView9);
        amount10 = findViewById(R.id.TextView10);
        amount11 = findViewById(R.id.TextView11);
        amount12= findViewById(R.id.TextView12);
        amount13= findViewById(R.id.TextView13);
        amount14= findViewById(R.id.TextView14);
        amount15 = findViewById(R.id.TextView15);*/
        Log.d("sharma iteration" ,Integer.toString(iteration));
    }

    public void IncreaseScore(){
        amount1 = findViewById(amount[iteration]);
        amount1.setTextColor(Color.YELLOW);
        if(iteration < 14) {
            amount2 = findViewById(amount[iteration +1]);
            amount2.setTextColor(Color.BLACK);
            Log.d("sharma iteration1" ,Integer.toString(iteration));
        }
        iteration--;
    }
}
