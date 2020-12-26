package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class AdminAddNewProduct extends AppCompatActivity {

    private String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        selectedCategory= getIntent().getExtras().get("category").toString();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}