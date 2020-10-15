package com.sharma.crorepathi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.io.IOException;
import java.util.Random;

public class GamePage extends AppCompatActivity {

    ImageButton AudiencePoll;
    ImageButton phone;
    ImageButton fifty;
    ImageButton Score;
    JsonReader mJsonReader;
    Button Question;
    Button Answer1;
    Button Answer2;
    Button Answer3;
    Button Answer4;
    Question CurrentQuestion;
    Handler handler;
    ProgressBar progressA;
    ProgressBar progressB;
    ProgressBar progressC;
    ProgressBar progressD;

    GameOver gameOver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        AudiencePoll = findViewById(R.id.audience);
        phone = findViewById(R.id.phone);
        fifty = findViewById(R.id.fifty);
        Score = findViewById(R.id.score);
        Question = findViewById(R.id.Question);
        Answer1 = findViewById(R.id.Answer1);
        Answer2 = findViewById(R.id.Answer2);
        Answer3 = findViewById(R.id.Answer3);
        Answer4 = findViewById(R.id.Answer4);
        progressA = (ProgressBar) findViewById(R.id.A);
        progressB = findViewById(R.id.B);
        progressC = findViewById(R.id.C);
        progressD = findViewById(R.id.D);
        final ScoreDialog SDialog = new ScoreDialog(GamePage.this);
         gameOver = new GameOver(GamePage.this);

        handler = new Handler();
        try {
            mJsonReader = new JsonReader(getApplicationContext());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        AudiencePoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MyDialog dialog = new MyDialog(GamePage.this,CurrentQuestion);
                dialog.show();
                AudiencePoll.setEnabled(false);
                AudiencePoll.setAlpha(.1f);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneDialog dialog = new PhoneDialog(GamePage.this);
                dialog.show();
            }
        });
        fifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count =0;
                if(1 != CurrentQuestion.getCorrect_choice()){
                    if(count !=2) {
                        Answer1.setVisibility(View.INVISIBLE);
                        count++;
                    }
                }
                if(2 != CurrentQuestion.getCorrect_choice()){
                   if(count!=2) {
                       Answer2.setVisibility(View.INVISIBLE);
                       count++;
                   }
                }
                if(3 != CurrentQuestion.getCorrect_choice()){
                    if(count !=2 ) {
                        Answer3.setVisibility(View.INVISIBLE);
                        count++;
                    }
                }
                fifty.setEnabled(false);
                fifty.setAlpha(.1f);
            }
        });
        Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              SDialog.show();
            }
        });
        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(1 == CurrentQuestion.getCorrect_choice()){
                    Answer1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right));
                    SDialog.IncreaseScore();
                }else{
                    Answer1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wrong));
                    gameOver.show();
                }
                setDisabled();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Answer1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.answer_button));
                        fetchQuestion();
                    }
                },1000);

            }
        });
        Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(2 == CurrentQuestion.getCorrect_choice()){
                    Answer2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right));
                    SDialog.IncreaseScore();
                }else{
                    Answer2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wrong));
                    gameOver.show();
                }
                setDisabled();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Answer2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.answer_button));
                        fetchQuestion();
                    }
                },1000);
            }
        });
        Answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(3 == CurrentQuestion.getCorrect_choice()){
                    Answer3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right));
                    SDialog.IncreaseScore();
                }else{
                    Answer3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wrong));
                    gameOver.show();
                }
                setDisabled();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Answer3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.answer_button));
                        fetchQuestion();
                    }
                },1000);
            }
        });
        Answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(4 == CurrentQuestion.getCorrect_choice()){
                    Answer4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right));
                    SDialog.IncreaseScore();
                }else{
                    Answer4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.wrong));
                    gameOver.show();
                }
                setDisabled();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Answer4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.answer_button));
                        fetchQuestion();
                    }
                },1000);
            }
        });


        fetchQuestion();

    }

    public void fetchQuestion(){
        int random = new Random().nextInt(mJsonReader.getNumberOfQuestion());
        Log.d("sharma",Integer.toString(random));
        setDefault();
        CurrentQuestion = mJsonReader.getQuestion(random);
        Answer1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.answer_button));
        Question.setText(CurrentQuestion.getQuestion());
        Answer1.setText(CurrentQuestion.getAnswer1());
        Answer2.setText(CurrentQuestion.getAnswer2());
        Answer3.setText(CurrentQuestion.getAnswer3());
        Answer4.setText(CurrentQuestion.getAnswer4());

    }

    public void setDefault(){
        Answer1.setVisibility(View.VISIBLE);
        Answer2.setVisibility(View.VISIBLE);
        Answer3.setVisibility(View.VISIBLE);
        Answer4.setVisibility(View.VISIBLE);
        Answer1.setEnabled(true);
        Answer2.setEnabled(true);
        Answer3.setEnabled(true);
        Answer4.setEnabled(true);


    }
    public void setDisabled(){
        Answer1.setEnabled(false);
        Answer2.setEnabled(false);
        Answer3.setEnabled(false);
        Answer4.setEnabled(false);


    }
}