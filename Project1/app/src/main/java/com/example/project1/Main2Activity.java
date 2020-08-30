package com.example.project1;

/**
 * created by Gurbir Singh
 */

/**
 * imported files
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * attributes
 */

public class Main2Activity extends AppCompatActivity {
    ImageView small;
    ImageView medium;
    ImageView large;
    ImageView extralarge;

    /**
     * values declared for image views
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        small = findViewById(R.id.imageView3);
        medium = findViewById(R.id.imageView5);
        large = findViewById(R.id.imageView4);
        extralarge = findViewById(R.id.imageView6);

        /**
         * to select different Pizza sizes various buttons been given
         * with onClick method and with intent for topping interface
         */
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Main2Activity.this, Toppings.class);
                startActivity(intToHome);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Main2Activity.this, Toppings.class);
                startActivity(intToHome);
            }
        });
        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Main2Activity.this, Toppings.class);
                startActivity(intToHome);
            }
        });
        extralarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Main2Activity.this, Toppings.class);
                startActivity(intToHome);
            }
        });
    }
}
