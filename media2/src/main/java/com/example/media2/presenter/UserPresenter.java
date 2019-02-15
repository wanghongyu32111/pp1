package com.example.media2.presenter;

import com.example.media2.bean.ProductEs;
import com.example.media2.interfaces.CallBanck;
import com.example.media2.interfaces.ProductCallBack;
import com.example.media2.model.IProductModelIble;
import com.example.media2.model.IUserModelable;
import com.example.media2.model.ProductModel;
import com.example.media2.model.UserModel;
import com.example.media2.view.IProductFragmentIble;
import com.example.media2.view.IUserLoginable;

public class UserPresenter implements IUserPresenterable{
    IUserLoginable login;
    IUserModelable modelable;
    //登陆注册视图层的接口
    IProductModelIble iProductModelIble;

    //请求产品视图层的接口
    IProductFragmentIble fragmentIble;

    public UserPresenter(IUserLoginable loginable){
        this.login = loginable;
        modelable = new UserModel();
        iProductModelIble = new ProductModel();
    }

    public UserPresenter(IProductFragmentIble fragmentIble){
        this.fragmentIble = fragmentIble;
        modelable = new UserModel();
        iProductModelIble = new ProductModel();
    }

    @Override
    public void toSave(String userName, String pwd) {
        modelable.saveDate(userName, pwd, new CallBanck() {
            @Override
            public void succse(String succseStr) {
                login.refreshDisply(succseStr);
            }

            @Override
            public void error(String errorStr) {
                login.refreshDisply(errorStr);
            }
        });
    }

    @Override
    public void toLogin(String userName, String pwd) {
        modelable.readDate(userName, pwd, new CallBanck() {
            @Override
            public void succse(String succseStr ) {
                //校验成功
                login.refreshDisply(succseStr);
            }

            @Override
            public void error(String errorStr) {
                //校验失败
                login.refreshDisply(errorStr);
            }
        });
    }

    @Override
    public void getDetilteProductDate(String url) {
        iProductModelIble.requstNet(url, new ProductCallBack() {
            @Override
            public void productSussce(ProductEs productEs) {
                fragmentIble.productRefreshDisply(productEs);
            }

            @Override
            public void productError(String json) {
                //暂不操作
            }
        });
    }
}
