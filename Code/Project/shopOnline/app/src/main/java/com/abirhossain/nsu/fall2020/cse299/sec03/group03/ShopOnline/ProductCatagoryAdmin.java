package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProductCatagoryAdmin extends AppCompatActivity {

    private ImageView laptop,watch, t_shirt, st_shirt, shoes, sweater, f_dress, h_phone, hat, glass, mobile, purse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catagory_admin);

        laptop = findViewById(R.id.laptops);
        watch = findViewById(R.id.watches);
        t_shirt = findViewById(R.id.tShirts);
        st_shirt = findViewById(R.id.StSHirts);
        shoes = findViewById(R.id.shoes);
        sweater = findViewById(R.id.sweater);
        f_dress = findViewById(R.id.fdress);
        h_phone = findViewById(R.id.hphone);
        hat = findViewById(R.id.hats);
        glass = findViewById(R.id.glasses);
        mobile = findViewById(R.id.mobile);
        purse = findViewById(R.id.bag);

        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Laptop");
                startActivity(intent);
            }
        });
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Watch");
                startActivity(intent);
            }
        });
        t_shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Regular T-shirt");
                startActivity(intent);
            }
        });
        st_shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Sports T-shirt");
                startActivity(intent);
            }
        });
        f_dress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Female Dress");
                startActivity(intent);
            }
        });
        h_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Head Phone");
                startActivity(intent);
            }
        });
        hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Hat");
                startActivity(intent);
            }
        });
        glass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Sun Glass");
                startActivity(intent);
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Smartphone");
                startActivity(intent);
            }
        });
        purse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Purse");
                startActivity(intent);
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Shoe");
                startActivity(intent);
            }
        });
        sweater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductCatagoryAdmin.this,AdminAddNewProduct.class);
                intent.putExtra("category","Sweater");
                startActivity(intent);
            }
        });



    }
}