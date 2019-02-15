package com.example.media2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.media2.R;
import com.example.media2.adpter.DetileProductAdpter;
import com.example.media2.bean.ProductEs;
import com.example.media2.presenter.IUserPresenterable;
import com.example.media2.presenter.UserPresenter;
import com.example.media2.view.IProductFragmentIble;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

public class DetileProductFragment extends Fragment implements IProductFragmentIble{

    RecyclerView recyclerView;
    IUserPresenterable presenterable;
    List<ProductEs.ResultEs> pList;
    DetileProductAdpter detileProductAdpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rieht_productcat_fragment_item , null);
        presenterable =  new UserPresenter(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rihte_recyc_id);
        recyclerView .setLayoutManager(new GridLayoutManager(getActivity(),3));
        requstDate();
    }

    public void requstDate(){
        String url = "http://172.17.8.100/small/commodity/v1/bannerShow";
    //    pList = new ArrayList<ProductEs.ResultEs>();
        presenterable.getDetilteProductDate(url);

    }

    @Override
    public void productRefreshDisply(ProductEs productEs) {
        pList = productEs.result;
        detileProductAdpter = new DetileProductAdpter(pList);
        recyclerView.setAdapter(detileProductAdpter);
    }
}
