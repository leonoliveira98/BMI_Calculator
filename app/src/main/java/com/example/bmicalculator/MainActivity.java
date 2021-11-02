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
        Toast.makeText(MainActivity.this, "Calculate Button works!",
                Toast.LENGTH_LONG).show();
    }


}