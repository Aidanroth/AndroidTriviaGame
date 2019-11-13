package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button navButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navButton = findViewById(R.id.nav_button);

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* Need to retrieve question data and store it before starting game:
                    public DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference(); //gets root of the FireBase JSON Tree
                    initialize a vector/map/queue/data structure
                    initialize randArray of ints to keep track of rand #'s
                    loop 5 times (# of questions in game):
                        while (randNum is in randArray)
                            generate a random # between 1 and # of Q's in chosen category
                        public DatabaseReference childRef = rootRef.child("CHOSEN_CATEGORY").child(String.valueOf(randNum));
                        Question question = dataSnapshot.getValue(Question.class);
                        store question in data structure
                    send data structure to question_view
                 */


                Intent intent = new Intent(MainActivity.this, question_view.class);
                startActivity(intent);
            }
        });
    }
}
