package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}