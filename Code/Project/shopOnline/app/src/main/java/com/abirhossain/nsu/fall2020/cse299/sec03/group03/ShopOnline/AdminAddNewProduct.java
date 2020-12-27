package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AdminAddNewProduct extends AppCompatActivity {

    private String selectedCategory;
    private EditText product_name,product_desc, product_price;
    private ImageView product_img;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        selectedCategory= getIntent().getExtras().get("category").toString();
        product_name= findViewById(R.id.NewProductName);
        product_desc= findViewById(R.id.NewProductDesc);
        product_price = findViewById(R.id.NewProductPrice);
        product_img = findViewById(R.id.NewProductImg);
        addBtn = findViewById(R.id.NewProductAddBtn);

        product_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImage();
            }
        });





    }

    private void addImage() {

        
    }
}