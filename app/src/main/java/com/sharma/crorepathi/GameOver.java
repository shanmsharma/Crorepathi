package com.sharma.crorepathi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;


public class GameOver extends Dialog {
    Button mbutton;
    Context mContext;
    public GameOver(@NonNull Context context) {
        super(context);
        mContext = context;
        setContentView(R.layout.gameover);
        mbutton = findViewById(R.id.ok);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,MainActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
}
