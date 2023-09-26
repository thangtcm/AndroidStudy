package com.example.labone;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText InputA;
    private EditText InputB;
    private TextView myResult;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputA = findViewById(R.id.editTexta);
        InputB = findViewById(R.id.editTextb);
        findViewById(R.id.editTextb);
        Button btnCal = findViewById(R.id.buttonCal);
        myResult = findViewById(R.id.textViewResult);
        btnCal.setOnClickListener(v -> {
            int a = Integer.parseInt(InputA.getText().toString());
            int b = Integer.parseInt(InputB.getText().toString());
            int area = a * b;
            int perimeter = (a + b) * 2;
            myResult.setText("Area: " + area + " Perimeter: " + perimeter);
        });

    }
}