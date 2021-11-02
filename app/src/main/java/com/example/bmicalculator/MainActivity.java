package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

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

        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);

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
                double bmiResult = calculateBMI();

                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);

                if(age >= 18){
                    displayResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }

            }
        });
    }


    private double calculateBMI() {
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        // Converting the number 'Strings' into 'int' variables
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        // Height in meters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        // BMI formula = weight in kg divided by height in meters squared
        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi){

        // We must convert the decimal/double into a string for our TextView
        // Before:
        //String bmiTextResult = String.valueOf(bmi);

        // After:
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if(bmi < 18.5){
            // Display underweight
            fullResultString = bmiTextResult + " - You are underweight";

        } else if (bmi > 25) {
            // Display overweight
            fullResultString = bmiTextResult + " - You are overweight";

        } else {
            // Display healthy
            fullResultString = bmiTextResult + " - You are healthy";

        }

        resultText.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if(maleButton.isChecked()){
            // Display boy guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with " +
                    "your doctor for the healthy range for boys";
        } else if(femaleButton.isChecked()) {
            // Display girl guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with " +
                    "your doctor for the healthy range for girls";
        } else {
            // Display general guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with " +
                    "your doctor for the healthy range";
        }

        resultText.setText(fullResultString);
    }

}