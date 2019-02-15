package com.example.media2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.media2.R;
import com.example.media2.adpter.ProductAdpter;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryFragment extends Fragment{
    List<String> productList;
    RecyclerView recyclerView;
    ProductAdpter productAdpter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_productcat_fragment_item , null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.left_recyc_id);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        productList = new ArrayList<String>();
        for(int i = 0 ; i < 10 ; i++) {
            productList.add("商品");
        }
        productAdpter = new ProductAdpter(productList , getContext());
        recyclerView.setAdapter(productAdpter);
    }

}
