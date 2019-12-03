package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    public static final String SHARED_PREFS = "sharedPrefs";
//    public static final String DIFF = "diff";
//    public static final String CATT = "catt";
//    public static final String MODE = "mode";

    Button navButton;
   // private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

        public void onClickQuestions(View view){
            Intent questionIntent = new Intent(getBaseContext(),QuestionActivity.class);
            startActivity(questionIntent);
        }

        public void onClickSettings(View view){
            Intent settingsIntent = new Intent(getBaseContext(),settings_activity.class);
            startActivity(settingsIntent);
        }

} // End class
