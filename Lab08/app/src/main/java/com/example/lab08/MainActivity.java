package com.example.lab08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bt_read,bt_write;
    EditText et_input;
    EditText et_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_input = (EditText) findViewById(R.id.editTextTextMultiLine);
        et_result = (EditText) findViewById(R.id.editTextTextMultiLine2);
        bt_read = (Button) findViewById(R.id.buttonRead);
        bt_write = (Button) findViewById(R.id.buttonWrite);
        bt_write.setOnClickListener(view -> {
            String noteInput = et_input.getText().toString();
            SharedPreferences sharedPrefWrite = getSharedPreferences("MyPreferences",
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPrefWrite.edit();
            editor.putString("note", noteInput);
            editor.apply(); //Update data don't return anything
            //editor.commit(); //Update data return:True/False
        });
        bt_read.setOnClickListener(view -> {
            SharedPreferences sharedPref = getSharedPreferences("MyPreferences",
                    MODE_PRIVATE);
            String noteContent = sharedPref.getString("note", "Your note");
            et_result.setText(noteContent);
        });
    }
}