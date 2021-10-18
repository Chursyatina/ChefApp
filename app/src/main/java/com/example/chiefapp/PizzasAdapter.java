package com.example.chiefapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PizzasAdapter extends RecyclerView.Adapter<PizzasAdapter.PizzaViewHolder>{

    private static int viewHolderCount;
    public int numberOfItems;

    public PizzasAdapter(int numberOfItems){
        this.numberOfItems = numberOfItems;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.menu_pizza;


        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(layoutIdForListItem, parent, false);

        PizzaViewHolder viewHolder = new PizzaViewHolder(view);
        viewHolder.orderNumber.setText("Order number" + viewHolderCount);

        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class PizzaViewHolder extends RecyclerView.ViewHolder{

        ImageView pizzaPhoto;
        TextView pizzaName;
        TextView orderDate;
        TextView orderNumber;

        public PizzaViewHolder(View itemView) {
            super(itemView);

            pizzaPhoto = itemView.findViewById(R.id.pizza_photo);
            pizzaName = itemView.findViewById(R.id.pizza_name);
            orderDate = itemView.findViewById(R.id.order_date);
            orderNumber = itemView.findViewById(R.id.order_number);
        }

        void bind(int listIndex) {
            orderNumber.setText(String.valueOf(listIndex));
        }
    }
}
