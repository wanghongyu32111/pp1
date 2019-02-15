package com.example.wanghongyu20190116;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MPadapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentss=new ArrayList<Fragment>();
    private List<String> lists=new ArrayList<String>();

    public MPadapter(FragmentManager fm, ArrayList<Fragment> fragmentss, List<String> lists) {
        super(fm);
        this.fragmentss = fragmentss;
        this.lists = lists;
    }

    public MPadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentss.get(i);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lists.get(position);
    }
}
