package com.sharma.crorepathi;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonReader {
    Context mContext;

    public Question getQuestion(int index) {
        return QuestionBank.get(index);
    }

    ArrayList<Question> QuestionBank ;
    int numberOfQuestion ;
    public JsonReader(Context context) throws IOException, JSONException {
        mContext = context;
        LoadJsonFile();


    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void LoadJsonFile() throws IOException, JSONException {
        InputStream is = mContext.getAssets().open("question.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        String jsonString = new String(buffer, "UTF-8");
        JSONObject object = new JSONObject(jsonString);
        JSONArray jsonArray = object.getJSONArray("Questions");
        QuestionBank  = new ArrayList<Question>();
        numberOfQuestion = jsonArray.length();
        Log.d("sharma" ,Integer.toString(numberOfQuestion));
        for(int i=0; i <jsonArray.length();i++ ) {
            JSONObject Jobject = jsonArray.getJSONObject(i);
           // Log.d("sharma",Jobject.toString());
           // Log.d("sharma",Jobject.getString("question"));
            Question q = new Question(Jobject);
            QuestionBank.add(q);
          //  Log.d("sharma", q.Question);
        }
    }
}
