package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CheckoutActivity extends AppCompatActivity {

    private EditText coName,coPhone,coAddress,coCity;
    private Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        coName = findViewById(R.id.coName);
        coPhone = findViewById(R.id.coPhone);
        coAddress = findViewById(R.id.coAddress);
        coCity = findViewById(R.id.coCity);
        placeOrderBtn = findViewById(R.id.placeOrderBtn);

    }
}