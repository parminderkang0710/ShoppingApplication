package com.example.project1;
/**
 * created by Gurbir Singh
 */

/**
 * files needed to import
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * various attributes
 */

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnSignIn;

    /**
     * values declared for attributes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        btnSignIn = findViewById(R.id.login);

/**
 * method declare for Signin button
 */
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * username and password correct login will success
                 * and Redirecting message will be shown
                 */
                if(username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent intToHome = new Intent(MainActivity.this, Home.class);
                    startActivity(intToHome);
                    /**
                     * if username and password one field of them is incorrect "Wrong credentials"
                     * message will pop up
                     */
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }


                }
        });
    }
}
