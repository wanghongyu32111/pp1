package com.example.media2.model;

import android.util.Log;

import com.example.media2.bean.ProductEs;
import com.example.media2.interfaces.ProductCallBack;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductModel implements IProductModelIble{

    @Override
    public void requstNet(String url , final ProductCallBack callBack) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求成功
                String jsonStr = response.body().string();
                Log.e("tag" ,"jsonStr == " + jsonStr);
                Gson gson = new Gson();
                ProductEs  productEs = gson.fromJson(jsonStr ,ProductEs.class );

                callBack.productSussce(productEs);
            }
        });
    }
}
