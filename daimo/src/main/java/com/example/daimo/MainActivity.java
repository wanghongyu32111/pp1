package com.example.daimo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.daimo.fragment.f1;
import com.example.daimo.fragment.f2;
import com.example.daimo.fragment.f3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private List<Fragment> list=new ArrayList<Fragment>();
    private ViewPager ViewPager1;
    private RadioGroup RadioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager1 = findViewById(R.id.ViewPager1);
        RadioGroup1 = findViewById(R.id.RadioGroup1);

        list.add(new f1());
        list.add(new f2());
        list.add(new f3());
        ViewPager1.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });



    }
}
