package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
     EditText editTextNumber1, editTextNumber2;
      Button buttonPlus, buttonMinus;
      TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       //linking objects with design by id
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
    }

    public void plus(View view) {
        double number1 = Double.parseDouble(editTextNumber1.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());

         textViewResult.setText((number1+number2)+"");

        if(editTextNumber1.getText().toString().equals(""))
            Toast.makeText(this,"Empty number1", Toast.LENGTH_LONG).show();

        if(editTextNumber2.getText().toString().equals(""))
            Toast.makeText(this,"Empty number2", Toast.LENGTH_LONG).show();

    }

    public void minus(View view) {
        double number1 = Double.parseDouble(editTextNumber1.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());

        textViewResult.setText((number1-number2)+"");

        if(editTextNumber1.getText().toString().equals(""))
            Toast.makeText(this,"Empty number1", Toast.LENGTH_LONG).show();

        if(editTextNumber2.getText().toString().equals(""))
            Toast.makeText(this,"Empty number2", Toast.LENGTH_LONG).show();
    }
}