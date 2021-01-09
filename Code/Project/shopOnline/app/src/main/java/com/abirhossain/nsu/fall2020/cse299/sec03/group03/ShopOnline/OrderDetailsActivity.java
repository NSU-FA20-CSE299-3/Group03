package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ModelClasses.Products;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class OrderDetailsActivity extends AppCompatActivity {

    private ImageView productImage;
    private ElegantNumberButton BtnNumber;
    private TextView pPrice, pDesc, pName;
    private String pId = "";
    private ImageView backBtn;
    private Button addToCartBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pId = getIntent().getStringExtra("id");
        setContentView(R.layout.activity_order_details);
        productImage = findViewById(R.id.details_image);
        BtnNumber = findViewById(R.id.elegant_button);
        pPrice = findViewById(R.id.details_Price_display);
        pDesc = findViewById(R.id.details_desc_display);
        pName = findViewById(R.id.details_Name_display);
        backBtn = findViewById(R.id.backBtnDetails);
        addToCartBtn = findViewById(R.id.addToCartButton);
        productDetails(pId);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });

        
    }

    private void addToCart() {
    }

    private void productDetails(String pId) {
        DatabaseReference productRef = FirebaseDatabase.getInstance().getReference().child("Products");
        productRef.child(pId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Products products = snapshot.getValue(Products.class);
                    pName.setText(products.getName());
                    pDesc.setText(products.getDescription());
                    pPrice.setText(products.getPrice());
                    Picasso.get().load(products.getImg()).into(productImage);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}