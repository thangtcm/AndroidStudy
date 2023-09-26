package com.example.labtwo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView text_Result;
    public EditText text_arr;
    public Button btn_Random, btn_Down, btn_Reverse, btn_MaxMin, btn_Ascened;
    int[] arr = new int[10];
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_Result = findViewById(R.id.textViewLarge);
        text_arr = findViewById(R.id.editTextArr);
        btn_Random = findViewById((R.id.btnRandom));
        btn_Ascened = findViewById(R.id.btnAscend);
        btn_Down = findViewById(R.id.btnDown);
        btn_Reverse = findViewById(R.id.btnReverse);
        btn_MaxMin = findViewById(R.id.btnMaxMin);

        btn_Random.setOnClickListener(v -> {
            Random rd = new Random();
            for (int i = 0; i < 10; i++) {
                arr[i] = rd.nextInt(50 - 10 + 1) + 10;
            }
            ArraytoEditText();
        });

        btn_Down.setOnClickListener(v -> ArraytoEditText());

        btn_Reverse.setOnClickListener(v -> {
            StringBuilder chuoi = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                chuoi.append(arr[i]).append(" ");
            }
            text_arr.setText(chuoi.toString());
        });

        btn_MaxMin.setOnClickListener(v -> {
            int min = arr[0];
            int max = arr[0];
            for (int i = 0; i < 10; i++) {
                if (arr[i] < min) min = arr[i];
                if (arr[i] > max) max = arr[i];
            }
            text_Result.setText("Min: " + min + " max: " + max);
        });

        btn_Ascened.setOnClickListener(v -> {
            int[] arrclone = new int[10];
            arrclone = arr;
            StringBuilder chuoi= new StringBuilder();
            sort(arrclone, 0, 9);
            for(int i =0; i < 10; i++)
            {
                chuoi.append(arrclone[i]).append(" ");
            }
            text_arr.setText(chuoi.toString());
        });
    }

    public void ArraytoEditText()
    {
        StringBuilder chuoi= new StringBuilder();
        for(int i=0;i<10; i++)
        {
            chuoi.append(arr[i]).append(" ");
        }
        text_arr.setText(chuoi.toString());
    }

    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

}