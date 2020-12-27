package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class AdminAddNewProduct extends AppCompatActivity {

    private String selectedCategory, desc, name, price, date, time, key;
    private EditText product_name,product_desc, product_price;
    private ImageView product_img;
    private Button addBtn;
    private static final int PickedImage= 1;
    private Uri ImageUri;

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
        
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productValidation();
            }
        });


    }



    private void addImage() {

        Intent openGallery = new Intent();
        openGallery.setAction(Intent.ACTION_GET_CONTENT);
        openGallery.setType("image/*");
        startActivityForResult(openGallery,PickedImage);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PickedImage){
            if (resultCode==RESULT_OK){
                if (data!=null){
                    ImageUri = data.getData();
                    product_img.setImageURI(ImageUri);
                }
            }
        }
    }

    private void productValidation() {

        name = product_name.getText().toString();
        desc = product_desc.getText().toString();
        price = product_price.getText().toString();
        if (ImageUri==null)
        {
            Toast.makeText(AdminAddNewProduct.this, "Image Not Selected", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(desc))
        {
            Toast.makeText(AdminAddNewProduct.this, "Description not given", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(price))
        {
            Toast.makeText(AdminAddNewProduct.this, "Price not given", Toast.LENGTH_SHORT).show();
        }
        else {
            storeData();
        }

    }

    private void storeData() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd,yyyy");
        date= currentDate.format(calendar.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm,ss a");
        time= currentTime.format(calendar.getTime());
        key = date+time;

    }
}