package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Go to Product page");
    }

    public LiveData<String> getText() {
        return mText;
    }
}