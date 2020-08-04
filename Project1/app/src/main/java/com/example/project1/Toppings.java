package com.example.project1;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        select = findViewById(R.id.buttontopping);

       select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intToHome = new Intent(Toppings.this, Home.class);
                    startActivity(intToHome);



            }
        });
    }
}
