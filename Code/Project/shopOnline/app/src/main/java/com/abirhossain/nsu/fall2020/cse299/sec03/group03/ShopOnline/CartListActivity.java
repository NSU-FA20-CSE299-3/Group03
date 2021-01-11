package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button prcdToOrderBtn;
    private TextView totalPrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        recyclerView = findViewById(R.id.cartItems);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        prcdToOrderBtn = findViewById(R.id.orderNowBtn);
        totalPrice = findViewById(R.id.totalItemPrice);
    }
}