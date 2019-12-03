package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class ResultsActivity extends AppCompatActivity {

    //Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        setContentView(R.layout.activity_results);
        TextView textView = (TextView) findViewById(R.id.current_score);
        //textView.setText();   // will need to get score variable from QuestionActivity to display here.

        //menuButton = findViewById(R.id.menuButton);

    }


    public void onClickMenu(View view) {
        Intent menuIntent = new Intent(this, MainActivity.class);
        startActivity(menuIntent);
    }


}
