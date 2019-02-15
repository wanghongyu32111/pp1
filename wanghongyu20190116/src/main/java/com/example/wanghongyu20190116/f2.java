package com.example.wanghongyu20190116;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.example.wanghongyu20190116.R;
import com.example.wanghongyu20190116.pd.BlankFragment;
import com.example.wanghongyu20190116.pd.FragmentFive;
import com.example.wanghongyu20190116.pd.FragmentFour;
import com.example.wanghongyu20190116.pd.FragmentSix;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class f2 extends Fragment {

    private TabLayout tab2;
    private Button btt2;
    private ViewPager vp2;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    private ArrayList<ChannelBean> channelBeanArrayList = new ArrayList<ChannelBean>();
    private MPagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_f2,container,false);

        tab2 = view.findViewById(R.id.tab2);
        btt2 = view.findViewById(R.id.btt2);
        vp2 = view.findViewById(R.id.vp2);

        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChannelActivity.startChannelActivity((AppCompatActivity) getActivity(),channelBeanArrayList);
            }
        });

        channelBeanArrayList.add(new ChannelBean("热点", true));
        channelBeanArrayList.add(new ChannelBean("北京", true));
        channelBeanArrayList.add(new ChannelBean("房价", true));

        channelBeanArrayList.add(new ChannelBean("旅游", false));
        channelBeanArrayList.add(new ChannelBean("条目1", false));
        channelBeanArrayList.add(new ChannelBean("条目2", false));

        for (int i = 0; i < channelBeanArrayList.size(); i++) {

            if (channelBeanArrayList.get(i).isSelect()) {
                //tb:是findViewById找到的tab;
                String name = channelBeanArrayList.get(i).getName();
                tab2.addTab(tab2.newTab().setText(name));

                if (i == 0) {
                    fragmentArrayList.add(new FragmentFour());
                }else if (i == 1){
                    fragmentArrayList.add(new FragmentFive());
                }else if(i == 2){
                    fragmentArrayList.add(new FragmentSix());
                }else{
                    fragmentArrayList.add(new BlankFragment());
                }

            }

        }

        mPagerAdapter = new MPagerAdapter(getChildFragmentManager());

        vp2.setAdapter(mPagerAdapter);

        tab2.setupWithViewPager(vp2);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String stringExtra = data.getStringExtra(ChannelActivity.RESULT_JSON_KEY);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ChannelBean>>(){}.getType();   // 把json直接转换成集合;

        channelBeanArrayList = gson.fromJson(stringExtra, type); // 吧json转换成集合

        tab2.removeAllTabs(); //清空 tab
        fragmentArrayList.clear();   //清空 所有Fragment

        // 重新生成新的tab, 重新生成新的Fragment;
        for (int i = 0; i < channelBeanArrayList.size(); i++) {
            ChannelBean channelBean = channelBeanArrayList.get(i);
            if (channelBean.isSelect()) {
                //tb:是findViewById找到的tab;
                tab2.addTab(tab2.newTab().setText(channelBean.getName()));

                if ("热点".equals(channelBean.getName())) {
                    fragmentArrayList.add(new FragmentFour());
                }else if ("北京".equals(channelBean.getName())){
                    fragmentArrayList.add(new FragmentFive());
                }else if("房价".equals(channelBean.getName())){
                    fragmentArrayList.add(new FragmentSix());
                }else{
                    fragmentArrayList.add(new BlankFragment());
                }

            }
        }

        mPagerAdapter.notifyDataSetChanged();


    }

    private class MPagerAdapter extends FragmentPagerAdapter {


        public MPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentArrayList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return channelBeanArrayList.get(position).getName();
        }
    }



}
