package com.example.media2.model;

import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.media2.interfaces.CallBanck;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserModel implements IUserModelable{


    @Override
    public void saveDate(String userName, String pwd, CallBanck callBanck) {
        //请求网络数据
        //post 提交表单

        String url = "http://172.17.8.100/small/user/v1/register";
        OkHttpClient okHttpClient3 = new OkHttpClient();
        RequestBody body1 = new FormBody.Builder()
                .add("phone" ,userName)
                .add("pwd" ,pwd)
                .build();
        Request request3 = new Request.Builder()
                .url(url)
                .post(body1)
                .build();
        okHttpClient3.newCall(request3).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("tag", response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    Log.e("tag", headers.name(i) + ":" + headers.value(i));
                }
                Log.d("tag", "onResponse: " + response.body().string());
            }
        });

    }

    @Override
    public void readDate(String userName, String pwd , CallBanck callBanck) {
        //请求网络做数据校验
        int a = 0;
        if(a == 0){
            //校验成功
            callBanck.succse("登陆成功");
        }else {
            //校验失败
            callBanck.error("登陆失败");





        }
    }
}
