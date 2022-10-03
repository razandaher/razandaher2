package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signinctivity extends AppCompatActivity {

    private EditText etMail, etPassword;
    private Button buttonRegister, buttonCancel;
    private TextView Signin;


    SharedPreferences preferences; //calss - capital letter / object - small letter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinctivity);

        etMail = findViewById(R.id.editTextetMail);
         etPassword = findViewById(R.id.editTextetPassword);
         buttonCancel = findViewById(R.id.buttonCancel);
         buttonRegister = findViewById(R.id.buttonRegister);
          // creates a preferences file
         preferences = getSharedPreferences("Userinfo", 0); //read and write permission for application
    }

    public void Register(View view){

     String input_mail = etMail.getText().toString();
        String input_password = etPassword.getText().toString();

        if(input_mail.length()>0) {
            // open preference file
            SharedPreferences.Editor editor = preferences.edit();
            // saves key, value data (users email)
            editor.putString("username", input_mail);
            editor.putString("password", input_password);

            editor.apply();
            Toast.makeText(this, "User registered",Toast.LENGTH_LONG).show();
            Intent intent_main = new Intent(this, MainActivity.class);
            startActivity(intent_main);
        }
        else{
            Toast.makeText(this, "Empty values, please insert",Toast.LENGTH_SHORT).show();
        }



    }

    public void cancel(View view) {
        Intent intent_main = new Intent(this, MainActivity.class);
        startActivity(intent_main);
    }

    public void signin(View view) {
        Intent intent_home = new Intent(this, HomeActivity.class);
        startActivity(intent_home);
    }
}