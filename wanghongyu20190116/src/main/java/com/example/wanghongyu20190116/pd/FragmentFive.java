package com.example.wanghongyu20190116.pd;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentFive extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        Bundle bundle = getArguments();
        //String name = bundle.getString("name");
        double random = Math.random();
        textView.setText("我是第二个tab");
        return textView;
    }

    public static FragmentFive getInstances(String name) {
        FragmentFive blankFragment = new FragmentFive();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        blankFragment.setArguments(bundle);
        return blankFragment;

    }


}
