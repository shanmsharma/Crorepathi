package com.sharma.crorepathi;

import org.json.JSONException;
import org.json.JSONObject;

public class Question {

    String Question;
    String Answer1;
    String Answer2;
    String Answer3;
    String Answer4;
    int correct_choice;

    public Question(JSONObject Js) throws JSONException {
     Question = Js.getString("question");
     Answer1 = Js.getString("Answer1");
     Answer2 = Js.getString("Answer2");
     Answer3 = Js.getString("Answer3");
     Answer4 = Js.getString("Answer4");
     correct_choice = Js.getInt("choice");


    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(String answer1) {
        Answer1 = answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String answer2) {
        Answer2 = answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(String answer3) {
        Answer3 = answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public void setAnswer4(String answer4) {
        Answer4 = answer4;
    }

    public int getCorrect_choice() {
        return correct_choice;
    }

    public void setCorrect_choice(int correct_choice) {
        this.correct_choice = correct_choice;
    }
}
