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
    CheckBox check1,check2,check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        select = findViewById(R.id.buttontopping);
        check1=findViewById(R.id.checkBox_dog);
        check2=findViewById(R.id.checkBox_cat);
        check3=findViewById(R.id.checkBox_cow);

       select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1.isChecked() || check2.isChecked() || check3.isChecked()) {


                    Intent intToHome = new Intent(Toppings.this, Home.class);
                    startActivity(intToHome);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Select atleast one topping",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
