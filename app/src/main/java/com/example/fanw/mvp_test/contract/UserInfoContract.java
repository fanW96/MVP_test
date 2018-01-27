package com.example.fanw.mvp_test.contract;

import com.example.fanw.mvp_test.model.UserInfoModel;
import com.example.fanw.mvp_test.presenter.BasePresenter;
import com.example.fanw.mvp_test.view.BaseView;

/**
 * Created by fanw on 2018/1/27.
 */

/*
* 在契约中创建两个接口
* 分别对应view和presenter
* 实现方法分别是UI操作和数据业务逻辑
* */
public interface UserInfoContract {
    interface View extends BaseView<Presenter>{
        void showLoading();//展示加载框
        void dismissLoading();//取消加载框
        void showUserInfo(UserInfoModel userInfoModel);//将网络请求的用户信息回调
        String loadUserId();//假设请求接口需要一个userId
    }
    interface Presenter extends BasePresenter{
        void loadUserInfo();
    }
}
