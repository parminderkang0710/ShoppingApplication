package com.example.project1;
/**
 * Created by Arshpreet KAur Bhullar
 */


import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * attributes for list view such as
 * adapter and recycle view
 * and firebase
 */
public class MyOrdersActivity extends AppCompatActivity {

    private List<Order> dataList;
    OrderAdapter adapter;
    RecyclerView recyclerView;
    FirebaseFirestore mFirebaseFirestore;
    String TAG = "MyOrdersActivity";
    String userId;
    SharedPreferences sharedPreferences;

    /**
     * values set for attributes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        mFirebaseFirestore = FirebaseFirestore.getInstance();
        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        userId = sharedPreferences.getString("UserId", "0");
        dataList = new ArrayList<>();
        // setup recycler view
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new OrderAdapter(this, dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        getListItems();
        // get items from list
    }


    private void getListItems() {
        mFirebaseFirestore.collection("orders").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot documentSnapshots) {
                        if (documentSnapshots.isEmpty()) {
                            Log.d(TAG, "onSuccess: LIST EMPTY");
                            return;
                        } else {
                            // Convert the whole Query Snapshot to a list
                            // of objects directly! No need to fetch each
                            // document.
                            List<Order> types = documentSnapshots.toObjects(Order.class);
                            //   String id, String pizza, String size, String total, String userid, int price, int qt
                            for (int i = 0; i < types.size(); i++) {
                                if (TextUtils.equals(types.get(i).getUserid(), userId)) {
                                    Order order = new Order(types.get(i).getId(), types.get(i).getPizza(), types.get(i).getSize(), types.get(i).getTotal(), types.get(i).getUserid(),
                                            types.get(i).getPrice(), types.get(i).getQty());
                                    dataList.add(order);
                                }


                            }

                           /* // Add all to your list
                            dataList.addAll(types);
                            Log.d(TAG, "onSuccess: " + dataList);*/
                            adapter.notifyDataSetChanged();
                        }
                    }


                });

    }

}
