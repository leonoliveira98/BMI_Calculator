package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Ir buscar os Id's do XML e mete-los em variaveis
        TextView resultText = findViewById(R.id.text_view_result);

        RadioButton maleButton = findViewById(R.id.radio_button_female);
        RadioButton femaleButton = findViewById(R.id.radio_button_male);

        EditText ageEditText = findViewById(R.id.edit_text_age);
        EditText feetEditText = findViewById(R.id.edit_text_feet);
        EditText inchesEditText = findViewById(R.id.edit_text_inches);
        EditText weightEditText = findViewById(R.id.edit_text_weight);

        Button calculateButton = findViewById(R.id.button_calculate);


    }



}