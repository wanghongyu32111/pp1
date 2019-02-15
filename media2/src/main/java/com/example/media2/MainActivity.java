package com.example.media2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.media2.interfaces.WeatherModel;
import com.example.media2.model.WeatherModelImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,WeatherModel {

    WeatherModelImpl weather;
    private EditText cityNOInput;
    private TextView city;
    public Button but_go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        cityNOInput  = findViewById(R.id.ed_id);
        city =  findViewById(R.id.te_id);
        but_go = findViewById(R.id.but_id);
        but_go.setOnClickListener(this);
        weather = new WeatherModelImpl();
    }

    @Override
    public void onClick(View view) {
        Log.e("tag" ,"执行 onClick ");
        weather.setInterfaceWeatherModelImpl(this);
        weather.requst();
    }


    @Override
    public void onSuccess(String str) {
        Toast.makeText(this , str , 1).show();
    }

    @Override
    public void onError(String str) {
        Toast.makeText(this , str , 0).show();
    }
}
