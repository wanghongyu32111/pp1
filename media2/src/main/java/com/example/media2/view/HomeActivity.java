package com.example.media2.view;

import android.app.Activity;
import android.app.ActivityManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.media2.R;
import com.example.media2.fragment.DetileProductFragment;
import com.example.media2.fragment.ProductCategoryFragment;

public class HomeActivity extends FragmentActivity{

    ProductCategoryFragment productCategoryFragment;
    DetileProductFragment detileProductFragment;
    FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction transaction;
    android.support.v4.app.FragmentTransaction pTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);
        productCategoryFragment = new ProductCategoryFragment();
        detileProductFragment = new DetileProductFragment();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.left_layout_id , productCategoryFragment);
        transaction.commit();

        pTransaction = fragmentManager.beginTransaction();
        pTransaction.replace(R.id.right_layout_id ,detileProductFragment );
        pTransaction.commit();
    }
}
