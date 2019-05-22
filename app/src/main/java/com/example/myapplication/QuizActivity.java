package com.example.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button buttonConfirmNext;
    private Integer AnswerNr;
    private boolean answered;

    private ColorStateList textColorDefaultButton;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        textColorDefaultButton = button1.getTextColors();

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered=true;
                AnswerNr = 1;
                if (AnswerNr == currentQuestion.getAnswerNr()){
                    score++;
                    textViewScore.setText("Score: " + score);
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                showSolution();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered=true;
                AnswerNr = 2;
                if (AnswerNr == currentQuestion.getAnswerNr()){
                    score++;
                    textViewScore.setText("Score: " + score);
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                showSolution();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered=true;
                AnswerNr = 3;
                if (AnswerNr == currentQuestion.getAnswerNr()){
                    score++;
                    textViewScore.setText("Score: " + score);
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                showSolution();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered=true;
                AnswerNr = 4;
                if (AnswerNr == currentQuestion.getAnswerNr()){
                    score++;
                    textViewScore.setText("Score: " + score);

                }else{
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                showSolution();
            }
        });

    }
    private void showNextQuestion() {
        button1.setTextColor(textColorDefaultButton);
        button2.setTextColor(textColorDefaultButton);
        button3.setTextColor(textColorDefaultButton);
        button4.setTextColor(textColorDefaultButton);

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            button1.setText(currentQuestion.getOption1());
            button2.setText(currentQuestion.getOption2());
            button3.setText(currentQuestion.getOption3());
            button4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
        } else {
            finishQuiz();
        }


    }
    private void showSolution(){
        if(currentQuestion.getAnswerNr()==1 && AnswerNr == 1){
            textViewQuestion.setText("Good answer");
        }
        else if (currentQuestion.getAnswerNr()==2 && AnswerNr == 2){
            textViewQuestion.setText("Good answer");
        }
        else if(currentQuestion.getAnswerNr()==3 && AnswerNr == 3){
            textViewQuestion.setText("Good answer");
        }
        else if(currentQuestion.getAnswerNr()==4 && AnswerNr == 4){
            textViewQuestion.setText("Good answer");
        }

    showNextQuestion();
    }

    private void finishQuiz(){
        finish();
    }
}
