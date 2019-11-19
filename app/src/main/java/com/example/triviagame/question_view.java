package com.example.triviagame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.triviagame.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class question_view extends AppCompatActivity {

    TextView questionText;
    Button button1, button2, button3, button4;

    public DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference(); //gets root of the FireBase JSON Tree
    public DatabaseReference childRef = rootRef.child("history_questions").child(String.valueOf(1));

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        questionText = findViewById(R.id.questionText);

        updateData();

    }

    private void updateData() {

        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final Question question = dataSnapshot.getValue(Question.class);

                questionText.setText(question.getQuestion());
                button1.setText(question.getOption1());
                button2.setText(question.getOption2());
                button3.setText(question.getOption3());
                button4.setText(question.getOption4());

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
                                    score++;
                                    button1.setBackgroundColor(Color.parseColor("#03A9F4"));


                                }
                            },1500);

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
                                    score++;
                                    button2.setBackgroundColor(Color.parseColor("#03A9F4"));


                                }
                            },1500);

                        }
                        else {  //if wrong, make correct button turn green
                            button2.setBackgroundColor(Color.RED);

                            if(button1.getText().toString().equals(question.getAnswer())) {
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
                                    score++;
                                    button3.setBackgroundColor(Color.parseColor("#03A9F4"));


                                }
                            },1500);

                        }
                        else {  //if wrong, make correct button turn green
                            button3.setBackgroundColor(Color.RED);

                            if(button1.getText().toString().equals(question.getAnswer())) {
                                button2.setBackgroundColor(Color.GREEN);
                            }
                            else if(button2.getText().toString().equals(question.getAnswer())) {
                                button3.setBackgroundColor(Color.GREEN);
                            }
                            else if(button4.getText().toString().equals(question.getAnswer())) {
                                button4.setBackgroundColor(Color.GREEN);
                            }

                        }
                    }
                });

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (button4.getText().toString().equals(question.getAnswer())) { //if answer is correct
                            button4.setBackgroundColor(Color.GREEN);

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    score++;
                                    button4.setBackgroundColor(Color.parseColor("#03A9F4"));


                                }
                            },1500);

                        }
                        else {  //if wrong, make correct button turn green
                            button4.setBackgroundColor(Color.RED);

                            if(button1.getText().toString().equals(question.getAnswer())) {
                                button2.setBackgroundColor(Color.GREEN);
                            }
                            else if(button2.getText().toString().equals(question.getAnswer())) {
                                button3.setBackgroundColor(Color.GREEN);
                            }
                            else if(button3.getText().toString().equals(question.getAnswer())) {
                                button3.setBackgroundColor(Color.GREEN);
                            }

                        }
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
