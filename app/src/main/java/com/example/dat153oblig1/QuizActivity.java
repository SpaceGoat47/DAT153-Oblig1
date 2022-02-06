package com.example.dat153oblig1;

// Video: https://www.youtube.com/watch?v=aHm65Poz_GA&ab_channel=TechnoGeek

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private ImageView tvQuestion;
    private TextView  tvScore, tvQuestionNo, tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score = 0;


    ColorStateList dfrbColour;
    boolean answerd;


    CountDownTimer countDownTimer;

    private QuestionModel currentQuestion;

    private List<QuestionModel> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        questionsList = new ArrayList<>();
        tvQuestion = findViewById(R.id.imageViewQuestion);
        tvScore = findViewById(R.id.textScore);
        tvQuestionNo = findViewById(R.id.textQuestionNo);
        tvTimer = findViewById(R.id.textTimer);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btnNext = findViewById(R.id.btnNext);


        dfrbColour = rb1.getTextColors();


        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answerd)
                {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked())
                    {
                        checkAnswer();
                        countDownTimer.cancel();

                    }
                    else
                    {
                        Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    showNextQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        answerd = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected)+1;
        if (answerNo == currentQuestion.getCorrectAnsNo())
        {
            score++;
            tvScore.setText("Score: "+score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        switch(currentQuestion.getCorrectAnsNo())
        {
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
        }
        if (qCounter < totalQuestions)
        {
            btnNext.setText("Next");
        }
        else
        {
            btnNext.setText("Finish");
        }

    }

    private void showNextQuestion()
    {
        radioGroup.clearCheck();
        rb1.setTextColor(dfrbColour);
        rb2.setTextColor(dfrbColour);
        rb3.setTextColor(dfrbColour);

        if (qCounter < totalQuestions)
        {
            timer();
            currentQuestion = questionsList.get(qCounter);
            tvQuestion.setImageResource(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter ++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Question:  "+qCounter+"/"+totalQuestions);
            answerd = false;

        }
        else
        {
            finish();
        }
    }

    private void timer() {
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                tvTimer.setText("00:" + 1/1000);
            }

            @Override
            public void onFinish() {
                showNextQuestion();
            }
        }.start();
    }

    private void addQuestions() {
        questionsList.add(new QuestionModel(R.drawable.ic_launcher_foreground, "Riktig", "Feil", "Denne er og feil",1));
        questionsList.add(new QuestionModel(R.drawable.ic_cat, "Feil", "Riktig", "Feil",2));

    }
}
//  questionsList.add(new QuestionModel("B er rett?", "A", "B", "C",2));