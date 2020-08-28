package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class cart extends AppCompatActivity {
    Button checkout;
    ImageView home,check,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        checkout=findViewById(R.id.button5);
        home=findViewById(R.id.imageView);
        check=findViewById(R.id.imageView1);

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



