package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OrderDetailsActivity extends AppCompatActivity {
    private FloatingActionButton BtnAddToCart;
    private ImageView productImage;
    private ElegantNumberButton BtnNumber;
    private TextView pPrice, pDesc, pName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        productImage = findViewById(R.id.details_image);
        BtnNumber = findViewById(R.id.elegant_button);
        pPrice = findViewById(R.id.details_Price_display);
        pDesc = findViewById(R.id.details_desc_display);
        pName = findViewById(R.id.details_Name_display);

        
    }
}