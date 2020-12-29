package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ui.categories;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.R;

public class categories extends Fragment {

    private CategoriesViewModel mViewModel;

    public static categories newInstance() {
        return new categories();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.categories_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        // TODO: Use the ViewModel
    }

}