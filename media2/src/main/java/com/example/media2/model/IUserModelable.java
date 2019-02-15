package com.example.media2.model;

import com.example.media2.interfaces.CallBanck;

public interface IUserModelable {

    //保存数据
    public void saveDate(String userName , String pwd , CallBanck callBanck);

    public void readDate(String userName , String pwd ,CallBanck callBanck);
}
