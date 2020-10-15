package com.sharma.crorepathi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class PhoneDialog extends Dialog {
   Button mButton;
   EditText mEditText;
    public PhoneDialog(@NonNull final Context context) {
        super(context);
        this.setContentView(R.layout.phone);
        mButton = findViewById(R.id.send);
        mEditText = findViewById(R.id.EditText);
        this.setCancelable( true);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent dialIntent = new Intent();
                dialIntent.setAction(Intent.ACTION_CALL);
                dialIntent.setData(Uri.parse("tel:7408033442"));
                context.startActivity(dialIntent);*/
            }
        });
    }
}
