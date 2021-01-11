package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ModelClasses.cartList;
import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.Prevalent.Prevalent;
import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ViewHolder.cartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    @Override
    protected void onStart() {
        super.onStart();

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart");
        FirebaseRecyclerOptions<cartList> options =
                new FirebaseRecyclerOptions.Builder<cartList>()
                .setQuery(cartListRef.child("User view").child(Prevalent.onlineUsers.getPhone()).child("Products"),cartList.class).build();
        FirebaseRecyclerAdapter<cartList, cartViewHolder> adapter = new FirebaseRecyclerAdapter<cartList, cartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull cartViewHolder holder, int position, @NonNull cartList model) {
                holder.itemQuantityTV.setText(model.getQuantity());
                holder.itemPriceTV.setText(model.getPrice());
                holder.itemNameTV.setText(model.getpName());

            }

            @NonNull
            @Override
            public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_on_cart_layout,parent,false);
                cartViewHolder holder = new cartViewHolder(v);
                return  holder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
     }
}