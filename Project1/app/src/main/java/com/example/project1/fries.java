package com.example.project1;

/**
 * created by Gurbir Singh
 */

/**
 * files for buttons, views , intent
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * attributes for buttons
 */
public class fries extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button add;

    /**
     * value declaration for button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fries);
        add=findViewById(R.id.buttona);
        add.setOnClickListener(new View.OnClickListener() {

            /**
             * method to click button and to go back to home screen with given intent
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(fries.this, Home.class);
                startActivity(intToHome);
            }
        });
    }
}
