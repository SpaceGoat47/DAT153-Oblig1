package com.example.dat153oblig1;

// Video: https://www.youtube.com/watch?v=aHm65Poz_GA&ab_channel=TechnoGeek

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion, tvScore, tvQuestionNo, tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;

    private QuestionModel currentQuestion;

    private List<QuestionModel> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        questionsList = new ArrayList<>();
        tvQuestion = findViewById(R.id.textQuestion);
        tvScore = findViewById(R.id.textScore);
        tvQuestionNo = findViewById(R.id.textQuestionNo);
        tvTimer = findViewById(R.id.textTimer);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btnNext = findViewById(R.id.btnNext);


        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();
    }

    private void showNextQuestion()
    {
        if (qCounter < totalQuestions)
        {
            currentQuestion = questionsList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter ++;
        }
        else
        {
            finish();
        }
    }

    private void addQuestions() {
        questionsList.add(new QuestionModel("A er rett?", "A", "B", "C",1));
        questionsList.add(new QuestionModel("B er rett?", "A", "B", "C",2));
        questionsList.add(new QuestionModel("B er rett?", "A", "B", "C",3));
        questionsList.add(new QuestionModel("C er rett?", "A", "B", "C",3));
        questionsList.add(new QuestionModel("A er rett?", "A", "B", "C",1));
    }
}