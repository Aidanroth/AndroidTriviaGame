package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.lang.reflect.Array;


public class settings_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SharedPreferences sharedpreferences;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String DIFF = "diff";
    public static final String CATT = "catt";
    public static final String MODE = "mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_activity);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        String spin1V = sharedpreferences.getString(DIFF, "Easy");
        String spin2V = sharedpreferences.getString(MODE, "Single Player");
        String spin3V = sharedpreferences.getString(CATT, "Science");

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Difficulties, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        int spin1Pos = adapter.getPosition(spin1V);
        spinner.setSelection(spin1Pos);
        spinner.setOnItemSelectedListener(this);

        Spinner spinnerMode = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Mode, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMode.setAdapter(adapter1);
        int spin2Pos = adapter1.getPosition(spin2V);
        spinnerMode.setSelection(spin2Pos);
        spinnerMode.setOnItemSelectedListener(this);

        Spinner spinnerCategories = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Categories, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter2);
        int spin3Pos = adapter2.getPosition(spin3V);
        spinnerCategories.setSelection(spin3Pos);
        spinnerCategories.setOnItemSelectedListener(this);

    }


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

//            String text1 = parent.getItemAtPosition(position).toString() + " saved to settings";
//            Toast.makeText(parent.getContext(), text1, Toast.LENGTH_SHORT).show();

           // String text1 = parent.getItemAtPosition(position).toString();

            if(parent.getId() == R.id.spinner1){
                //first spinner clicked
                // Difficulty changed
                String temp = parent.getItemAtPosition(position).toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(DIFF, temp);
                editor.commit();

            }

            else if(parent.getId() == R.id.spinner2){
                // Game mode changed
                String temp = parent.getItemAtPosition(position).toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(MODE, temp);
                editor.commit();

            }

            else if(parent.getId() == R.id.spinner3){
                // Category changed
                String temp = parent.getItemAtPosition(position).toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(CATT, temp);
                editor.commit();

            }

        }

        @Override
                public void onNothingSelected(AdapterView<?> parent){

        }
}
