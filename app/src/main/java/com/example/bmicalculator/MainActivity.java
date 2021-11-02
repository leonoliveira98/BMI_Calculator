package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variaveis publicas onde todos os metodos conseguem aceder
    // Class variables; Are also called 'Fields'
    // 'private' to make it more secure
    private TextView resultText;
    private Button calculateButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Aqui a variavel 'calculateButton' apenas fica definida neste metodo e pode apenas ser usada aqui.
        // Quando definimos a variavel fora do metodo, o 'setOnClickListener' nao funciona pq nao a encontra
        //Button calculateButton = findViewById(R.id.button_calculate);

        // Call method
        findViews();
        setupButtonClickListener();

    }

    private void findViews(){

        // Ir buscar os Id's do XML e mete-los em variáveis
        // 'resultText' é agr uma class variable
        resultText = findViewById(R.id.text_view_result);

        maleButton = findViewById(R.id.radio_button_female);
        femaleButton = findViewById(R.id.radio_button_male);

        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);

        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageText = ageEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        // Converting the number 'Strings' into 'int' variables
        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        // Height in meters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        // BMI formula = weight in kg divided by height in meters squared
        double bmi = weight / (heightInMeters * heightInMeters);

        // We must convert the decimal/double into a string for our TextView
        String bmiTextResult = String.valueOf(bmi);

        resultText.setText(bmiTextResult);

    }


}