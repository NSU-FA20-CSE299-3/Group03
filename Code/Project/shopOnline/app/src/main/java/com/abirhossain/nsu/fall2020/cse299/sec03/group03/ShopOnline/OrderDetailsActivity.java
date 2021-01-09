package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ModelClasses.Products;
import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.Prevalent.Prevalent;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

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
        String currentTime,saveCurrentDate;
        Calendar callDate = Calendar.getInstance();
        SimpleDateFormat getDate = new SimpleDateFormat("MMM DD,yyyy");
        saveCurrentDate = getDate.format(callDate.getTime());

        SimpleDateFormat getTime = new SimpleDateFormat("HH:mm:ss a");
        currentTime = getDate.format(callDate.getTime());

        final DatabaseReference cartRef = FirebaseDatabase.getInstance().getReference().child("Cart");
        final HashMap<String,Object> cartMap = new HashMap<>();

        cartMap.put("pid",pId);
        cartMap.put("pName",pName.getText().toString());
        cartMap.put("price",pPrice.getText().toString());
        cartMap.put("date",saveCurrentDate);
        cartMap.put("time",currentTime);
        cartMap.put("quantity",BtnNumber.getNumber());
        cartMap.put("discount","");

        cartRef.child("User view").child(Prevalent.onlineUsers.getPhone()).child("Products").child(pId)
                .updateChildren(cartMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){

                            cartRef.child("Admin view").child(Prevalent.onlineUsers.getPhone()).child("Products").child(pId)
                                    .updateChildren(cartMap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(OrderDetailsActivity.this, "Product Added To Cart Successfully", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(OrderDetailsActivity.this,ShowProduct.class));

                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(OrderDetailsActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                                        }
                                    });

                        }

                    }
                });





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