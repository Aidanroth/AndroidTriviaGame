package com.example.triviagame.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import java.util.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyApplication extends Application {

    public Vector<Question> questionVector;

//    public void getQuestions (String category) {
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference(); //gets root of the FireBase JSON Tree
//
//        for (int i = 0; i < 5; i++) {   // loop to go through all questions in a category. Will probably need to hardcode number of questions.
//            DatabaseReference childRef = rootRef.child(category).child(String.valueOf(i));
//
//            //for loop based on number of questions in category
//            childRef.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    final Question question = dataSnapshot.getValue(Question.class);
//                    questionVector.add(question);
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        }
//    }

    public void writeData(Question question) {  //move code that displays question data on buttons & such


    }
}
