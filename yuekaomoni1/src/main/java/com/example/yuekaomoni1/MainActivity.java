package com.example.yuekaomoni1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private f1 f1;
    private f2 f2;
    private f3 f3;
    private FrameLayout fram;
    private RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fram = findViewById(R.id.fram);
         radio =findViewById(R.id.radio);
         f1 = new f1();
         f2 = new f2();
         f3 = new f3();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fram,f1);
        fragmentTransaction.add(R.id.fram,f2);
        fragmentTransaction.add(R.id.fram,f3);
        fragmentTransaction.show(f1).hide(f2).hide(f3);
        fragmentTransaction.commit();


        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.btn1:
                        fragmentTransaction1.show(f1).hide(f2).hide(f3);
                        break;
                    case R.id.btn2:
                        fragmentTransaction1.show(f2).hide(f1).hide(f3);
                        break;
                    case R.id.btn3:
                        fragmentTransaction1.show(f3).hide(f2).hide(f3);
                        break;
                }
                fragmentTransaction1.commit();
            }
        });





    }
}
