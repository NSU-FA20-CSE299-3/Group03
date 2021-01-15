package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckoutActivity extends AppCompatActivity {

    private EditText coName,coPhone,coAddress,coCity;
    private Button placeOrderBtn;
    private String TotalOrderPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        coName = findViewById(R.id.coName);
        coPhone = findViewById(R.id.coPhone);
        coAddress = findViewById(R.id.coAddress);
        coCity = findViewById(R.id.coCity);
        placeOrderBtn = findViewById(R.id.placeOrderBtn);
        TotalOrderPrice = getIntent().getStringExtra("Total Price");

       placeOrderBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               checkDetails();
           }
       });
    }

    private void checkDetails() {
        if (TextUtils.isEmpty(coName.getText().toString())){
            Toast.makeText(CheckoutActivity.this, "Empty field", Toast.LENGTH_SHORT).show();

        }
        else if (TextUtils.isEmpty(coPhone.getText().toString())){
            Toast.makeText(CheckoutActivity.this, "Empty field", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(coAddress.getText().toString())){
            Toast.makeText(CheckoutActivity.this, "Empty field", Toast.LENGTH_SHORT).show();

        }
        else if (TextUtils.isEmpty(coCity.getText().toString())){
            Toast.makeText(CheckoutActivity.this, "Empty field", Toast.LENGTH_SHORT).show();

        }
        else {
            placeOrder();
        }

    }

    private void placeOrder() {
        final String currentTime,saveCurrentDate;
        Calendar callDate = Calendar.getInstance();
        SimpleDateFormat getDate = new SimpleDateFormat("MMM DD,yyyy");
        saveCurrentDate = getDate.format(callDate.getTime());
        SimpleDateFormat getTime = new SimpleDateFormat("HH:mm:ss a");
        currentTime = getDate.format(callDate.getTime());
    }
}