package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity {
    ImageView pizza,logout,wings, imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pizza=findViewById(R.id.imageView3);
        logout=findViewById(R.id.imageView2);
        wings=findViewById(R.id.imageView5);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Home.this, Main2Activity.class);
                startActivity(intToHome);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Home.this, MainActivity.class);
                startActivity(intToHome);
            }
        });
        wings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(Home.this, Wings.class);
                startActivity(intToHome);

            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intoHome= new Intent(Home.this,MainActivity5.class);
                startActivity(intoHome);
            }
        });

    }
}
