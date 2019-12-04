package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class ResultsActivity extends AppCompatActivity {

    private TextView playerScoreValue;
    public static final String playerScore = "not working";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        setContentView(R.layout.activity_results);
        playerScoreValue = findViewById(R.id.player_score);
        Intent newIntent = getIntent();
        String score = newIntent.getStringExtra(ResultsActivity.playerScore);
        playerScoreValue.setText(score);
    }
    

    public void onClickMenu(View view) {
        Intent menuIntent = new Intent(this, MainActivity.class);
        startActivity(menuIntent);
    }

}
