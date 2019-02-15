

package com.example.wanghongyu20190116;

import com.example.wanghongyu20190116.R;
import com.example.wanghongyu20190116.f1;
import com.example.wanghongyu20190116.f2;
import com.example.wanghongyu20190116.f3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class MainActivity extends AppCompatActivity {

    private FrameLayout frag;
    private RadioGroup group;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private f1 one;
    private f2 two;
    private f3 three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag = findViewById(R.id.frag);
        group = findViewById(R.id.group);
        manager = getSupportFragmentManager();
        one = new f1();
        two = new f2();
        three = new f3();

        transaction = manager.beginTransaction();

        transaction.add(R.id.frag,one,"fragment1");
        transaction.add(R.id.frag,two,"fragment2");
        transaction.add(R.id.frag,three);

        transaction.show(one).hide(two).hide(three);
        transaction.commit();
        group.check(group.getChildAt(0).getId());

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId){
                    case R.id.butt1:
                        transaction1.show(one).hide(two).hide(three);
                        break;
                    case R.id.butt2:
                        transaction1.show(two).hide(one).hide(three);
                        break;
                    case R.id.butt3:
                        transaction1.show(three).hide(two).hide(one);
                        break;
                }
                transaction1.commit();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment2 = getSupportFragmentManager().findFragmentByTag("fragment2");
        fragment2.onActivityResult(requestCode,resultCode,data);
    }




}
