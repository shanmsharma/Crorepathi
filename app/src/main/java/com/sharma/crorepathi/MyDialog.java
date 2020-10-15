package com.sharma.crorepathi;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MyDialog extends Dialog
{
    ProgressBar mProgressBarA;
    ProgressBar mProgressBarB;
    ProgressBar mProgressBarC;
    ProgressBar mProgressBarD;
    TextView A_Percent;
    TextView B_Percent;
    TextView C_Percent;
    TextView D_Percent;

    int  MAX_PROGRESS = 100;
    Question CurrentQuestion;
    public MyDialog(final Context context, Question q )
    {
        // Set your theme here
        super(context);

        // This is the layout XML file that describes your Dialog layout
        this.setContentView(R.layout.audience);
        this.setTitle( "AUDIENCE POLL");
        this.setCancelable( true);
        CurrentQuestion = q ;
        mProgressBarA = (ProgressBar)findViewById(R.id.A) ;
        mProgressBarB = (ProgressBar)findViewById(R.id.B) ;
        mProgressBarC = (ProgressBar)findViewById(R.id.C) ;
        mProgressBarD = (ProgressBar)findViewById(R.id.D) ;
        A_Percent = findViewById(R.id.A_Percent);
        B_Percent = findViewById(R.id.B_percent);
        C_Percent = findViewById(R.id.C_percent);
        D_Percent = findViewById(R.id.D_percent);


        setProgression();
    }


    public void  setProgression(){
        Random r = new Random();
        int startValue = MAX_PROGRESS;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int rem;
        if(1 != CurrentQuestion.getCorrect_choice()){
            v1= r.nextInt(20);
            mProgressBarA.setProgress(v1);
            A_Percent.setText(Integer.toString(v1));
        }
         if(2 != CurrentQuestion.getCorrect_choice()) {
            v2 = r.nextInt(20);
            mProgressBarB.setProgress(v2);
            B_Percent.setText(Integer.toString(v2));
        }
        if(3 != CurrentQuestion.getCorrect_choice()) {
            v3 = r.nextInt(20);
            mProgressBarC.setProgress(v3);
            C_Percent.setText(Integer.toString(v3));
        }
         if(4 != CurrentQuestion.getCorrect_choice()){
            v4 = r.nextInt(20);
            mProgressBarD.setProgress(v4);
            D_Percent.setText(Integer.toString(v4));
        }

        if(1 == CurrentQuestion.getCorrect_choice()){
            rem = startValue - (v1+v2+v3+v4);
            mProgressBarA.setProgress(rem);
            A_Percent.setText(Integer.toString(rem));
        }
        else if(2 == CurrentQuestion.getCorrect_choice()) {
            rem = startValue - (v1+v2+v3+v4);
            mProgressBarB.setProgress(rem);
            B_Percent.setText(Integer.toString(rem));
        }
        else if(3 == CurrentQuestion.getCorrect_choice()) {
            rem = startValue - (v1+v2+v3+v4);
            mProgressBarC.setProgress(rem);
            C_Percent.setText(Integer.toString(rem));
        }
        else if(4 == CurrentQuestion.getCorrect_choice()){
            rem = startValue - (v1+v2+v3+v4);
            mProgressBarD.setProgress(rem);
            D_Percent.setText(Integer.toString(rem));
        }
    }
}