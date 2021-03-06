package com.example.project1;
/**
 * created By Dilpreet Singh
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * attributes for buttons
 */
public class Wings extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wings);
        /**
         * to find radio group by id
         */
        radioGroup = findViewById(R.id.radiogroup);
        add = findViewById(R.id.buttona);
       add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * intent to move from wings to home interface
                 */
                Intent intToHome = new Intent(Wings.this, Home.class);
                startActivity(intToHome);
            }
        });

    }

}

