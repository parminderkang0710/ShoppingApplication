package com.example.project1;
/**
 * created by Dilpreet singh
 */

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

        /**
         * describes the item view and metadata
         * within recyleView
         * @param view
         */
        ViewHolder(View view) {
            super(view);

            tvPizza = view.findViewById(R.id.tvPizza);
            tvQty = view.findViewById(R.id.tvQty);
            tvPrice = view.findViewById(R.id.tvPrice);
            tvTotalPrice = view.findViewById(R.id.tvTotalPrice);


        }


    }

    /**
     * adapter to fill data in UI component
     * as well as to hold and show the data
     * as list view or gridview
     * @param mContext
     * @param orderList
     */
    public OrderAdapter(Context mContext, List<Order> orderList) {
        this.context = mContext;
        this.orderList = orderList;

    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
// to configure running device and to get current context "LayoutInflater" is used
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);


        return new OrderAdapter.ViewHolder(itemView);

    }

    /**
     * onblindviewHolder used for rows to get new data and replace old one
     * with help of view holders
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final OrderAdapter.ViewHolder holder, final int position) {
/**
 * to set and get the pizza price and quantity
 */
        order = orderList.get(position);
        holder.tvPizza.setText(order.getPizza());
        holder.tvPrice.setText(String.format("Price : %s$", order.getPrice()));
        holder.tvTotalPrice.setText(String.format("Total Price : %s$", order.getPrice()));
        holder.tvQty.setText(String.format("Qty. : %s", order.getQty()));


    }

    /**
     * to get list of orders
     * @return
     */
    @Override
    public int getItemCount() {
        return orderList.size();
    }


}