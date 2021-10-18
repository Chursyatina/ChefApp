package com.example.chiefapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OwnPizzasAdapter extends RecyclerView.Adapter<OwnPizzasAdapter.OwnPizzaViewHolder>{

    private static int viewHolderCount;
    public int numberOfItems;
    private Context parent;

    public OwnPizzasAdapter(int numberOfItems, Context parent){
        this.numberOfItems = numberOfItems;
        viewHolderCount = 0;
        this.parent = parent;
    }

    @NonNull
    @Override
    public OwnPizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.taken_pizza;


        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(layoutIdForListItem, parent, false);

        OwnPizzasAdapter.OwnPizzaViewHolder viewHolder = new OwnPizzasAdapter.OwnPizzaViewHolder(view);
        viewHolder.orderDate.setText("Order ..." + viewHolderCount);

        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OwnPizzaViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class OwnPizzaViewHolder extends RecyclerView.ViewHolder{

        ImageView pizzaPhoto;
        TextView pizzaName;
        TextView orderDate;
        Button recipeButton;

        public OwnPizzaViewHolder(View itemView) {
            super(itemView);

            pizzaPhoto = itemView.findViewById(R.id.pizza_photo);
            pizzaName = itemView.findViewById(R.id.pizza_name);
            orderDate = itemView.findViewById(R.id.order_date);

            recipeButton = itemView.findViewById(R.id.recipe_button);
            recipeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    Intent intent = new Intent(parent, SinglePizzaActivity.class);
                    intent.putExtra("order", String.valueOf(position));
                    parent.startActivity(intent);
                }
            });
        }

        void bind(int listIndex) {
            orderDate.setText(String.valueOf(listIndex + ".05.2022"));
        }
    }
}
