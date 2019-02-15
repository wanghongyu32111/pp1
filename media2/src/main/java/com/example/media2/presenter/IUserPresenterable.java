package com.example.media2.presenter;

public interface IUserPresenterable {

    //针对登陆的接口
    public void toSave(String userName , String pwd);
    public void toLogin(String userName , String pwd);

    //正对产品的一些回调接口
    public void getDetilteProductDate(String url);


}
