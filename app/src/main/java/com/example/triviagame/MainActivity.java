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
    }
        public void onClickQuestions(View view){
            Intent questionIntent = new Intent(getBaseContext(),question_view.class);
            startActivity(questionIntent);
        }

        /*public void onClickSettings(View view){
            Intent settingsIntent = new Intent(getBaseContext(),SettingsActivity.class);
            startActivity(settingsIntent);
        }*/

}
