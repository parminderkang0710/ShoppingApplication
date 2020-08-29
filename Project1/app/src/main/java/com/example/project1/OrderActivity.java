package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import me.himanshusoni.quantityview.QuantityView;


public class OrderActivity extends AppCompatActivity implements QuantityView.OnQuantityChangeListener {

    ImageView ivPizza;
    TextView tvName, tvPrice, tvTotalPrice;
    String size, name, userId;
    int price, qty=1;
    Button btnOrder;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        size = getIntent().getStringExtra("size");
        ivPizza = findViewById(R.id.ivPizza);

        if (TextUtils.equals(size, "small")) {
            ivPizza.setImageResource(R.drawable.small);
        } else if (TextUtils.equals(size, "medium")) {
            ivPizza.setImageResource(R.drawable.medium);
        } else if (TextUtils.equals(size, "large")) {
            ivPizza.setImageResource(R.drawable.large);
        } else if (TextUtils.equals(size, "extralarge")) {
            ivPizza.setImageResource(R.drawable.xtralarge);
        }

        tvName = findViewById(R.id.tvName);
        name = getIntent().getStringExtra("name");
        tvName.setText(name);

        tvPrice = findViewById(R.id.tvPrice);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        price = getIntent().getIntExtra("price", 0);
        tvPrice.setText(price + "$");
        tvTotalPrice.setText(price + "$");

        final QuantityView quantityViewDefault = (QuantityView) findViewById(R.id.qty);
        quantityViewDefault.setOnQuantityChangeListener(this);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        userId = sharedPreferences.getString("UserId", "0");

        btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (qty > 0) {
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    String id = db.collection("orders").document().getId();

                    Map<String, Object> order = new HashMap<>();
                    order.put("id", id);
                    order.put("pizza", name);
                    order.put("size", size);
                    order.put("price", price);
                    order.put("total", tvTotalPrice.getText().toString());
                    order.put("qty", qty);
                    order.put("userid", userId);


                    db.collection("orders").document(id)
                            .set(order)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(OrderActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(OrderActivity.this, DashboardActivity.class);
                                    startActivity(i);
                                    finish();

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    //Log.w(TAG, "Error writing document", e);
                                }
                            });


                } else {
                    Toast.makeText(OrderActivity.this, "Qty. cannot be 0", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public void onQuantityChanged(int oldQuantity, int newQuantity, boolean programmatically) {
        qty = newQuantity;
        tvTotalPrice.setText((price * newQuantity) + "$");

    }

    @Override
    public void onLimitReached() {

    }
}
