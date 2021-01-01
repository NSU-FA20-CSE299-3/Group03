package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ui.home;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.Interfaces.ItemClickListener;

public class HomeViewModel extends ViewModel  {

    public ItemClickListener itemListener;

    Button button;


    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Go to Product page");

    }

    public LiveData<String> getText() {
        return mText;
    }
}