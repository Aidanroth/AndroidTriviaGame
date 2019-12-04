package com.example.triviagame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

import com.example.triviagame.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class QuestionActivity extends AppCompatActivity {

    public static final String DIFF = "diff";
    public static final String CATT = "catt";
    public static final String MODE = "mode";
    public static final String SHARED_PREFS = "sharedPrefs";

    SharedPreferences sharedpreferences;
    TextView questionText,player_score, current_score;
    Button button1, button2, button3, button4, buttonNextQ, beginButton;
    boolean first = true;




    ArrayList<Question> qVector = new ArrayList<>(50);
    int score = 0;
    int numQuestions = 7;
    int qNum = 0;
    Question question = new Question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String cat = sharedpreferences.getString(CATT, "Science");

        if(cat.equals("History")){
            cat = "history_questions";
            numQuestions = 2;
        }
        else if(cat.equals("Science")){
            cat = "science_questions";
            numQuestions = 7;
        }

        if(getQuestions(cat)) {

            button1 = findViewById(R.id.button1);
            button2 = findViewById(R.id.button2);
            button3 = findViewById(R.id.button3);
            button4 = findViewById(R.id.button4);
            beginButton = findViewById(R.id.begin_button);
            buttonNextQ = findViewById(R.id.buttonNextQ);
            questionText = findViewById(R.id.questionText);
            player_score = findViewById(R.id.player_score);
            current_score = findViewById(R.id.current_score);


            refreshScreen();

            checkSelection();
        }
    }

    private void checkSelection() {

        buttonNextQ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(qNum < numQuestions) {
                    refreshScreen();
                    button1.setBackgroundColor(Color.parseColor("#008577"));
                    button2.setBackgroundColor(Color.parseColor("#008577"));
                    button3.setBackgroundColor(Color.parseColor("#008577"));
                    button4.setBackgroundColor(Color.parseColor("#008577"));
                }
                else {  // Go to results screen
                    Intent resultsIntent = new Intent(QuestionActivity.this, ResultsActivity.class);
                    String newScore = String.valueOf(score);
                    resultsIntent.putExtra(ResultsActivity.playerScore, newScore);
                    startActivity(resultsIntent);
                }
            }
        });

        // button 1 click result logic
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button1.getText().toString().equals(question.getAnswer())) { //if answer is correct
                    button1.setBackgroundColor(Color.GREEN);


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            score+=50;
                            updateScore(score);
                        }
                    },300);


                }
                else {  //if wrong, make correct button turn green
                    button1.setBackgroundColor(Color.RED);

                    if(button2.getText().toString().equals(question.getAnswer())) {
                        button2.setBackgroundColor(Color.GREEN);
                    }
                    else if(button3.getText().toString().equals(question.getAnswer())) {
                        button3.setBackgroundColor(Color.GREEN);
                    }
                    else if(button4.getText().toString().equals(question.getAnswer())) {
                        button4.setBackgroundColor(Color.GREEN);
                    }

                }
            }
        });

        // button 2 click result logic
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2.getText().toString().equals(question.getAnswer())) { //if answer is correct
                    button2.setBackgroundColor(Color.GREEN);


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            score+=50;
                            updateScore(score);

                        }
                    },300);




                }
                else {  //if wrong, make correct button turn green
                    button2.setBackgroundColor(Color.RED);

                    if(button1.getText().toString().equals(question.getAnswer())) {
                        button1.setBackgroundColor(Color.GREEN);
                    }
                    else if(button3.getText().toString().equals(question.getAnswer())) {
                        button3.setBackgroundColor(Color.GREEN);
                    }
                    else if(button4.getText().toString().equals(question.getAnswer())) {
                        button4.setBackgroundColor(Color.GREEN);
                    }

                }
            }
        });

        // button 3 click result logic
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button3.getText().toString().equals(question.getAnswer())) { //if answer is correct
                    button3.setBackgroundColor(Color.GREEN);


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            score+=50;
                            updateScore(score);

                        }
                    },300);



                }
                else {  //if wrong, make correct button turn green
                    button3.setBackgroundColor(Color.RED);

                    if(button1.getText().toString().equals(question.getAnswer())) {
                        button1.setBackgroundColor(Color.GREEN);
                    }
                    else if(button2.getText().toString().equals(question.getAnswer())) {
                        button2.setBackgroundColor(Color.GREEN);
                    }
                    else if(button4.getText().toString().equals(question.getAnswer())) {
                        button4.setBackgroundColor(Color.GREEN);
                    }

                }
            }
        });

        // button 4 click result logic
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button4.getText().toString().equals(question.getAnswer())) { //if answer is correct
                    button4.setBackgroundColor(Color.GREEN);


                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            score+=50;
                            updateScore(score);
                        }
                    },300);


                }
                else {  //if wrong, make correct button turn green
                    button4.setBackgroundColor(Color.RED);

                    if(button1.getText().toString().equals(question.getAnswer())) {
                        button1.setBackgroundColor(Color.GREEN);
                    }
                    else if(button2.getText().toString().equals(question.getAnswer())) {
                        button2.setBackgroundColor(Color.GREEN);
                    }
                    else if(button3.getText().toString().equals(question.getAnswer())) {
                        button3.setBackgroundColor(Color.GREEN);
                    }

                }
            }
        });
    }


    private void refreshScreen() {

        // The first time this method is called the array list is empty even though it should have been generated already.
        // thats why the check for empty is neccessary to prevent a crash but it also means when you start the game you
        // see the default text values not the first question.
        if(!qVector.isEmpty()) {

            question = qVector.get(qNum);
            questionText.setText(question.getQuestion());
            button1.setText(question.getOption1());
            button2.setText(question.getOption2());
            button3.setText(question.getOption3());
            button4.setText(question.getOption4());
            qNum++;
        }

        else if(first == true){
            beginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    first = false;
                    beginButton.setVisibility(View.INVISIBLE);
                    refreshScreen();
                    questionText.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                    buttonNextQ.setVisibility(View.VISIBLE);
                    player_score.setVisibility(View.VISIBLE);
                    current_score.setVisibility(View.VISIBLE);

                }
            });
        }


    }


    public Boolean getQuestions (String category) {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference(); //gets root of the FireBase JSON Tree

        for (int i = 1; i <= numQuestions; i++) {   // loop to go through all questions in a category. Will probably need to hardcode number of questions.
            DatabaseReference childRef = rootRef.child(category).child(String.valueOf(i));

            //for loop based on number of questions in category
            childRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Question question1 = dataSnapshot.getValue(Question.class);
                    // System.out.println("Adding " + question1.question);
                    qVector.add(question1);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        Collections.shuffle(qVector, new Random(5));

        return true;
    }
    public void updateScore(int score){
        String newScore = String.valueOf(score);
        TextView textView = (TextView) findViewById(R.id.current_score);
        textView.setText(newScore);
    }



} // End class
