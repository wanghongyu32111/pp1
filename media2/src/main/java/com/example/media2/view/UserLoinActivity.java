package com.example.media2.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.media2.R;
import com.example.media2.presenter.IUserPresenterable;
import com.example.media2.presenter.UserPresenter;

public class UserLoinActivity extends Activity implements IUserLoginable ,View.OnClickListener{

    EditText UserName;
    EditText UserPwd;
    Button but_login;
    Button but_registe;
    IUserPresenterable presenterable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin_layout);
        presenterable = new UserPresenter(this);
        initView();

        ImageView imagView = new ImageView(this);

    }

    @Override
    public void doLogin() {

    }

    @Override
    public void refreshDisply(String str) {
        //刷新注册后的数据

        //继续跳转其他页面

    }

    public void initView(){

        UserName = findViewById(R.id.ed_UserName_id);
        UserPwd = findViewById(R.id.ed_PassWord_id);;
        but_login = findViewById(R.id.but_login_id);;
        but_registe = findViewById(R.id.but_regist_id);;
        but_login.setOnClickListener(this);
        but_registe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.but_login_id  == view.getId()){
            String userName_u = UserName.getText().toString();
            String userPwd_p = UserPwd.getText().toString();
            presenterable.toLogin(userName_u , userPwd_p);
        }

        if(R.id.but_regist_id  == view.getId()){
            String userName = UserName.getText().toString();
            String userPwd = UserPwd.getText().toString();
            presenterable.toSave(userName , userPwd);
        }
    }
}
