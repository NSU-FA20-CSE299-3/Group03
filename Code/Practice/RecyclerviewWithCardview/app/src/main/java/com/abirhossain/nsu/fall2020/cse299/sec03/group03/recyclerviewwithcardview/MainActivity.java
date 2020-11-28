package com.abirhossain.nsu.fall2020.cse299.sec03.group03.recyclerviewwithcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv =findViewById(R.id.recview);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new myadapter(dataqueue());
        rcv.setAdapter(adapter);

    }

    public ArrayList <modelClass> dataqueue(){

       ArrayList <modelClass> holder =new ArrayList<>();

        modelClass ob1 = new modelClass();
        ob1.setHeader("Mashrafee");
        ob1.setDesc("Previous captain of Bangladesh team");
        ob1.setImgname(R.drawable.mash);
        holder.add(ob1);

        modelClass ob2 = new modelClass();
        ob2.setHeader("Shakib");
        ob2.setDesc("No 1 Allrounder");
        ob2.setImgname(R.drawable.shakib);
        holder.add(ob2);

        modelClass ob3 = new modelClass();
        ob3.setHeader("Tamim");
        ob3.setDesc("Opener of Bangladesh Team");
        ob3.setImgname(R.drawable.tamim);
        holder.add(ob3);

        modelClass ob4 = new modelClass();
        ob4.setHeader("Mushfiqur");
        ob4.setDesc("Wicketkeepr of BD team");
        ob4.setImgname(R.drawable.mushi);
        holder.add(ob4);

        modelClass ob5 = new modelClass();
        ob5.setHeader("Mashrafee");
        ob5.setDesc("Previous captain of Bangladesh team");
        ob5.setImgname(R.drawable.mash);
        holder.add(ob5);

        modelClass ob6 = new modelClass();
        ob6.setHeader("Shakib");
        ob6.setDesc("No 1 Allrounder");
        ob6.setImgname(R.drawable.shakib);
        holder.add(ob6);

        modelClass ob7 = new modelClass();
        ob7.setHeader("Tamim");
        ob7.setDesc("Opener of Bangladesh Team");
        ob7.setImgname(R.drawable.tamim);
        holder.add(ob7);

        modelClass ob8 = new modelClass();
        ob8.setHeader("Mushfiqur");
        ob8.setDesc("Wicketkeepr of BD team");
        ob8.setImgname(R.drawable.mushi);
        holder.add(ob8);

        return holder;


    }

}