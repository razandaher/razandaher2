package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonLogin, buttonSignin;
    EditText editTextEmail, editTextPassword;
    private EditText etMail, etPassword;
    private TextView tvSignup, tvWelcome;

private final String valid_mail = "admin";
private final String valid_password = "1";
  SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignin = findViewById(R.id.buttonSignin);

        preferences = getSharedPreferences("Userinfo", 0);//read and write permission for application
    }

    public void login(View view) {
        if (editTextEmail.getText().toString().equals(""))
            Toast.makeText(this, "Empty Email", Toast.LENGTH_LONG).show();
        if (editTextPassword.getText().toString().equals(""))
            Toast.makeText(this, "Empty Password", Toast.LENGTH_LONG).show();
        else {
            //this line gets the registered email and password, in case no user was registered empty string is returned
            String registeredMail = preferences.getString("username", "");
            String registeredPassword = preferences.getString("password", "");

            String input_mail = etMail.getText().toString();
            String input_password = etPassword.getText().toString();

            if (input_mail.equals(registeredMail) && input_password.equals(registeredPassword)) {
                Intent i = new Intent(this, HomeActivity.class);
                startActivity(i);
            }
            else {
                Toast.makeText(this, "incorrect credentials", Toast.LENGTH_SHORT).show(); //wrong email or password
            }
        }
    }


    // loading the menu design into this activity
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // R-res + menu-menu file
        return true;
    }

    // handle option menu click events
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            // in case user chose help menu
            case R.id.help_menu:  Intent i = new Intent(this, helpActivity.class);
                startActivity(i); // open help activity when the help activity is selected
                // this-from where, the second parameter is to where
                break;

            case R.id.settings_menu:
                Intent x = new Intent(this, settingActivity.class);
                startActivity(x);
                break;

            case R.id.list_menu: Intent z = new Intent(this, listActivity.class);
                startActivity(z);
                Toast.makeText(MainActivity.this, "List clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() { // is called when the user clicks the back button
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Back Button was pressed");
        dialog.setMessage("Are ou sure you want to exit?");
        // In case the user chose no, Nothing happens, The dialog closes
        dialog.setNegativeButton("No",null);
        // When the user clicks on the yes button the application closes
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_close_24);
        AlertDialog alertDialog = dialog.create(); // create the dialog
        alertDialog.show(); // show the dialog
    }





    public void register(View view) {
        Intent i_register = new Intent(this, Signinctivity.class);
        startActivity(i_register);
    }
    }