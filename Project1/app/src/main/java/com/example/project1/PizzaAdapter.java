package com.example.project1;
/**
 * created by Parminder Singh
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * recycle view use to show list of items
 */
public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {
    /**
     * attributes
     */
    private Pizza pizza;
    private Context context;
    private List<Pizza> pizzaList;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName, tvPrice;
        ConstraintLayout constraintLayout;

        /**
         * describes the item view and metadata
         * within recyleView
         * @param view
         */

        ViewHolder(View view) {
            super(view);
/**
 * value declared for attributes
 */
            tvName = view.findViewById(R.id.tvName);
            tvPrice = view.findViewById(R.id.tvPrice);
            constraintLayout = view.findViewById(R.id.rowLayout);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                /**
                 * click method for pizza list
                 * @param v
                 */
                @Override
                public void onClick(View v) {
                    pizza = pizzaList.get(getAdapterPosition());
                    Intent i = new Intent(context, Main2Activity.class);
                    i.putExtra("price", Integer.parseInt(pizza.getPrice()));
                    i.putExtra("name", pizza.getName());
                    context.startActivity(i);
                }
            });

        }


    }

    public PizzaAdapter(Context mContext, List<Pizza> pizzaList) {
        this.context = mContext;
        this.pizzaList = pizzaList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza, parent, false);


        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        pizza = pizzaList.get(position);
        holder.tvName.setText(pizza.getName());
        holder.tvPrice.setText(String.format("%s$", pizza.getPrice()));


    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }


}