package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ViewHolder;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.Interfaces.ItemClickListener;
import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.R;

public class productViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView ShowProductName,ShowProductDesc;
    public ImageView ShowProductImage;
    public ItemClickListener itemListener;

    public productViewHolder(@NonNull View itemView) {
        super(itemView);
        ShowProductImage= itemView.findViewById(R.id.product_image_display);
        ShowProductName = itemView.findViewById(R.id.product_name_display);
        ShowProductDesc= itemView.findViewById(R.id.product_desc_display);


    }

    public void setItemClickListener(ItemClickListener listener){

        this.itemListener = listener;
    }



    @Override
    public void onClick(View v) {

        itemListener.onClick(v, getAdapterPosition(),false);

    }
}
