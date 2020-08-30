package com.example.project1;
/**
 * created by sandeep
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Toppings extends AppCompatActivity {
    Button select;
    CheckBox check1,check2,check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);
/**
 * values for attributes
 */
        select = findViewById(R.id.buttontopping);
        check1=findViewById(R.id.checkBox_dog);
        check2=findViewById(R.id.checkBox_cat);
        check3=findViewById(R.id.checkBox_cow);
/**
 * click method to select toppings
 */
       select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1.isChecked() || check2.isChecked() || check3.isChecked()) {

/**
 * go to home page
 */
                    Intent intToHome = new Intent(Toppings.this, Home.class);
                    startActivity(intToHome);
                }
                /**
                 * if user didn't select any topping
                 */
                else{
                    Toast.makeText(getApplicationContext(), "Select atleast one topping",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
