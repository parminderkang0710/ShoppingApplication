package com.example.project1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Order order;
    private Context context;
    private List<Order> orderList;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvPizza, tvQty, tvPrice, tvTotalPrice;
        ConstraintLayout constraintLayout;


        ViewHolder(View view) {
            super(view);

            tvPizza = view.findViewById(R.id.tvPizza);
            tvQty = view.findViewById(R.id.tvQty);
            tvPrice = view.findViewById(R.id.tvPrice);
            tvTotalPrice = view.findViewById(R.id.tvTotalPrice);


        }


    }

    public OrderAdapter(Context mContext, List<Order> orderList) {
        this.context = mContext;
        this.orderList = orderList;

    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);


        return new OrderAdapter.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final OrderAdapter.ViewHolder holder, final int position) {

        order = orderList.get(position);
        holder.tvPizza.setText(order.getPizza());
        holder.tvPrice.setText(String.format("Price : %s$", order.getPrice()));
        holder.tvTotalPrice.setText(String.format("Total Price : %s$", order.getPrice()));
        holder.tvQty.setText(String.format("Qty. : %s", order.getQty()));


    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }


}