package com.example.yuekao1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.yuekao1.fragment.fs1;
import com.example.yuekao1.fragment.fs2;
import com.example.yuekao1.fragment.fs3;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fram;
    private RadioGroup radio;
    private com.example.yuekao1.fragment.fs1 fs1;
    private com.example.yuekao1.fragment.fs2 fs2;
    private com.example.yuekao1.fragment.fs3 fs3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fram=findViewById(R.id.fram);
        radio = findViewById(R.id.radio);

        fs1 = new fs1();
        fs2 = new fs2();
        fs3 = new fs3();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fram,fs1);
        fragmentTransaction.add(R.id.fram,fs2);
        fragmentTransaction.add(R.id.fram,fs3);
        fragmentTransaction.show(fs1).hide(fs2).hide(fs3);
        fragmentTransaction.commit();
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.btn1:
                        fragmentTransaction1.show(fs1).hide(fs2).hide(fs3);
                        break;
                    case R.id.btn2:
                        fragmentTransaction1.show(fs2).hide(fs3).hide(fs3);
                        break;
                    case R.id.btn3:
                        fragmentTransaction1.show(fs3).hide(fs1).hide(fs3);
                        break;
                }
                fragmentTransaction1.commit();
            }
        });
    }
}
