package com.sharma.crorepathi;

import android.content.Context;

public class QuestionBank {

     Question[] mQuestionBanks;
     Context mContext;

    public QuestionBank(Context mContext) {
        this.mContext = mContext;

        InitBank();
    }

    private void InitBank() {



        return;
    }


    private String[] setAnswers(int id){
        String[] Questions = mContext.getResources().getStringArray(id);
        return Questions;
    }
}
