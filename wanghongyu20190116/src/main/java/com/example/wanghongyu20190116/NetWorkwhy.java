package com.example.wanghongyu20190116;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class NetWorkwhy {
    public static String getJson(String urlString){
        try {
            URL url = new URL(urlString);
         HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode==200){
                InputStream inputStream = httpURLConnection.getInputStream();
                String temp;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while ((temp=bufferedReader.readLine())!=null){
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(temp);
                    return stringBuffer.toString();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }
    //网络判断
    public static  boolean isconn(Context context){
        ConnectivityManager service = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = service.getActiveNetworkInfo();
        if (info!=null && info.isConnected()){
            return true;
        }else{
            return false;
        }
    }





}
