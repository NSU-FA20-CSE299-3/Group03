package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

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

        final DatabaseReference placeOrderRef = FirebaseDatabase.getInstance().getReference().child("Orders").child(Prevalent.onlineUsers.getPhone());
        HashMap<String,Object> placeOrderMap = new HashMap<>();
        placeOrderMap.put("TotalOrderPrice",TotalOrderPrice);
        placeOrderMap.put("User Name",coName.getText().toString());
        placeOrderMap.put("User Phone",coPhone.getText().toString());
        placeOrderMap.put("User Address",coAddress.getText().toString());
        placeOrderMap.put("User City",coCity.getText().toString());
        placeOrderMap.put("date",saveCurrentDate);
        placeOrderMap.put("time",currentTime);
        placeOrderMap.put("state","Not Delivered");

        placeOrderRef.updateChildren(placeOrderMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    FirebaseDatabase.getInstance().getReference().child("Cart")
                            .child("User view")
                            .child(Prevalent.onlineUsers.getPhone()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(CheckoutActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(CheckoutActivity.this,ShowProduct.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(CheckoutActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



    }
}