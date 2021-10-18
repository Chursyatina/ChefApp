package com.example.chiefapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrdersActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private androidx.recyclerview.widget.RecyclerView pizzasRecyclerView;
    private PizzasAdapter pizzasAdapter;
    private OwnPizzasAdapter ownPizzasAdapter;
    //private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        bottomNavigationView = findViewById(R.id.main_navigation);
        pizzasRecyclerView = findViewById(R.id.pizzas_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        pizzasRecyclerView.setLayoutManager(layoutManager);

        pizzasRecyclerView.setHasFixedSize(true);

        pizzasAdapter = new PizzasAdapter(100);
        ownPizzasAdapter = new OwnPizzasAdapter(10, this);

        pizzasRecyclerView.setAdapter(pizzasAdapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.All:
                        pizzasRecyclerView.setAdapter(pizzasAdapter);
                        break;
                    case R.id.My:
                        pizzasRecyclerView.setAdapter(ownPizzasAdapter);
                        break;
                }
                return true;
            }
        });
    }
}
