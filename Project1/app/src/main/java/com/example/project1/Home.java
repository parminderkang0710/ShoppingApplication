package com.example.project1;

/**
 * created by Parminder Singh
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * attributes for images
 */
public class Home extends AppCompatActivity {
    ImageView pizza,logout,wings,check,drinks,fries;

    /**
     * values given for images
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pizza=findViewById(R.id.imageView3);
        logout=findViewById(R.id.imageView2);
        wings=findViewById(R.id.imageView5);
        check=findViewById(R.id.imageView1);
        drinks=findViewById(R.id.imageView6);
        fries=findViewById(R.id.imageView4);
        pizza.setOnClickListener(new View.OnClickListener() {
            /**
             * method given to select pizza
             * so user can see different pizza options
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Home.this, Main2Activity.class);
                startActivity(intToHome);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            /**
             * method to make logout button click able
             * so user can come back to main screen from home
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Home.this, MainActivity.class);
                startActivity(intToHome);
            }
        });
        wings.setOnClickListener(new View.OnClickListener() {
            /**
             * method to go on wings interface
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Home.this, Wings.class);
                startActivity(intToHome);

            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            /**
             * to move on checkout and pay
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intoHome= new Intent(Home.this,Checkout.class);
                startActivity(intoHome);
            }
        });
        drinks.setOnClickListener(new View.OnClickListener() {
            /**
             * for drinks intreface
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intoHome= new Intent(Home.this,drink.class);
                startActivity(intoHome);
            }
        });
        fries.setOnClickListener(new View.OnClickListener() {
            /**
             * for Fries
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intoHome= new Intent(Home.this,fries.class);
                startActivity(intoHome);
            }
        });

    }
}
