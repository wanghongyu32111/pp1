package com.example.media2.model;

import com.example.media2.interfaces.WeatherModel;

public class WeatherModelImpl {


    WeatherModel weatherModel;
    public void requst(){
        //请求网络数据
        for(int i = 0 ; i < 20 ; i++){
            if(i <1){
                //表述请求成功
                weatherModel.onSuccess("成功了");
            }else {
                //表示请求失败
                weatherModel.onError("失败了");
                return;
            }
        }
    }

    public void setInterfaceWeatherModelImpl(WeatherModel  Interface){
        this.weatherModel = Interface;
    }
}
