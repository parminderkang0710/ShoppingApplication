package com.example.project1;

/**
 * created by Gurbir Singh
 */

/**
 * imported files
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * attributes declared
 */

public class cart extends AppCompatActivity {
    Button checkout;
    ImageView home,check,logout;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        /**
         * To find buttons by their id's
         */

        checkout=findViewById(R.id.button5);
        home=findViewById(R.id.imageView);
        check=findViewById(R.id.imageView1);
       /**
         *  click method with intent to come on this class from checkout and home
         */
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inTocheck= new Intent(cart.this,Checkout.class);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intoHome=new Intent(cart.this,Home.class);
            }
        });

    }
}



