package com.abirhossain.nsu.fall2020.cse299.sec03.group03.learnrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
 RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        String arr[] = {"Mash","Mushi","Shakib","Tamim","Mash","Mushi","Shakib","Tamim","Mash","Mushi","Shakib","Tamim"};

        rcv.setAdapter(new myAdapterClass(arr));{

        }

    }
}