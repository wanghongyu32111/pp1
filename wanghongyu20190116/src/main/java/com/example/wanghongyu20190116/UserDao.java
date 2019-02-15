package com.example.wanghongyu20190116;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserDao {
    private final SQLiteDatabase database;

    public UserDao(Context context){
        Sqlopen sqlopen = new Sqlopen(context);
        database = sqlopen.getReadableDatabase();
    }
    //添加
    public Void add(String text1){
        ContentValues values=new ContentValues();
        values.put("text1",text1);
        database.insert("users",null,values);
        return null;
    }
    //查询
    public ArrayList<Json.ResultBean> query(){
        Cursor query = database.query("users", null, null, null, null, null, null);
        ArrayList<Json.ResultBean> list=new ArrayList<Json.ResultBean>();
        while (query.moveToNext()){
            String text1 = query.getString(query.getColumnIndexOrThrow("text1"));
            Json.ResultBean resultBean = new Json.ResultBean(text1);
            list.add(resultBean);
        }
        return list;
    }





}
