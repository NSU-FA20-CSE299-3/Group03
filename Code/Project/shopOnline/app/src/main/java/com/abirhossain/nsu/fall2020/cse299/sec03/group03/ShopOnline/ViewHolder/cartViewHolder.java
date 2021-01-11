package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.Interfaces.ItemClickListener;
import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.R;

public class cartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView  itemNameTV, itemQuantityTV,itemPriceTV;
    private ItemClickListener itemClickListener;

    public cartViewHolder(@NonNull View itemView) {
        super(itemView);
        itemNameTV = itemView.findViewById(R.id.item_name);
        itemQuantityTV = itemView.findViewById(R.id.item_quantity);
        itemPriceTV = itemView.findViewById(R.id.item_price);



    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
