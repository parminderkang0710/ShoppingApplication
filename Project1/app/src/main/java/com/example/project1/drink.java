package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class drink extends AppCompatActivity {
    ImageView pepsi,coca,sprite,fanta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        pepsi=findViewById(R.id.imageView3);
        sprite=findViewById(R.id.imageView4);
        coca=findViewById(R.id.imageView5);
        fanta=findViewById(R.id.imageView6);
        pepsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(drink.this, Home.class);
                startActivity(intToHome);
            }
        });

        coca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(drink.this, Home.class);
                startActivity(intToHome);
            }
        });
        sprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(drink.this, Home.class);
                startActivity(intToHome);
            }
        });
        fanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(drink.this, Home.class);
                startActivity(intToHome);
            }
        });

    }
}
