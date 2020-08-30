package com.example.project1;

/**
 * created by Dilpreet Singh
 */

/**
 * imported files for firebase authentication
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * attributes for user ,name, buttons
 */


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    String userId;
    /**
     * sharedpreferences to retrive and store key pair
     * of files
     */
    SharedPreferences sharedPreferences;
    TextView tvName;
    Button btnNewOrder, btnOrders, btnProfile, btnLogout;

    /**
     * declared id's to store data in attributes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        userId = sharedPreferences.getString("UserId", "0");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        tvName = findViewById(R.id.tvName);
        db.collection("Users").document(userId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        tvName.setText(MessageFormat.format("Welcome, {0}", Objects.requireNonNull(Objects.requireNonNull(documentSnapshot.getData()).get("name")).toString()));
                        // Log.e("Name", documentSnapshot.getData().get("name").toString());

                    }
                });

        /**
         * buttons name declared to find views
         */
        btnNewOrder = findViewById(R.id.btnNewOrder);
        btnOrders = findViewById(R.id.btnOrders);
        btnProfile = findViewById(R.id.btnProfile);
        btnLogout = findViewById(R.id.btnLogout);

        /**
         * method declared for buttons to be clicked
         */
        btnNewOrder.setOnClickListener(this);
        btnOrders.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
/**
 * switch cases being used to test values
 * as intents given to move on furter classes by click on particular button
 */
        switch (v.getId()) {

            case R.id.btnNewOrder:
                Intent i = new Intent(DashboardActivity.this, PizzaActivity.class);
                startActivity(i);
                break;
            case R.id.btnOrders:
                Intent orders = new Intent(DashboardActivity.this, MyOrdersActivity.class);
                startActivity(orders);
                break;
            case R.id.btnProfile:
                Intent profile = new Intent(DashboardActivity.this, profile.class);
                startActivity(profile);
                break;
            case R.id.btnLogout:
                FirebaseAuth.getInstance().signOut();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent login = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(login);
                break;


        }

    }
}
