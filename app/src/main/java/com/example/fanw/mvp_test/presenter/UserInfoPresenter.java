package com.example.fanw.mvp_test.presenter;

import android.os.Handler;

import com.example.fanw.mvp_test.contract.UserInfoContract;
import com.example.fanw.mvp_test.model.UserInfoModel;

/**
 * Created by lenovoo on 2018/1/27.
 */

public class UserInfoPresenter implements UserInfoContract.Presenter {

    private UserInfoContract.View view;

    public UserInfoPresenter(UserInfoContract.View view){
        this.view = view;
        view.setPresenter(this);//在构造函数中直接调用了setPresenter方法
    }

    //初始化
    @Override
    public void start() {
        loadUserInfo();
    }

    @Override
    public void loadUserInfo() {
        String userId  = view.loadUserId();
        view.showLoading();//接口请求前显示loading
        //模拟请求回调
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟接口返回的json
                UserInfoModel userInfoModel = new UserInfoModel("fanw",21,"changzhou");
                view.showUserInfo(userInfoModel);
                view.dismissLoading();
            }
        },3000);
    }
}
