package com.example.fanw.mvp_test.activity;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fanw.mvp_test.R;
import com.example.fanw.mvp_test.contract.UserInfoContract;
import com.example.fanw.mvp_test.model.UserInfoModel;
import com.example.fanw.mvp_test.presenter.UserInfoPresenter;

public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.View{

    private UserInfoContract.Presenter presenter;

    private TextView name;
    private TextView age;
    private TextView address;
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        name = (TextView) findViewById(R.id.name);
        age = (TextView) findViewById(R.id.age);
        address = (TextView) findViewById(R.id.address);
        mConstraintLayout = (ConstraintLayout)findViewById(R.id.mConstraintLayout);

        //UserInfoActivity实现了UserInfoContract.View中的setPresenter()方法，
        // 而UserInfoPresenter 构造函数中已经调用了UserInfoContract.View中的setPresenter()方法
        new UserInfoPresenter(this);
        presenter.start();
    }

    @Override
    public void setPresenter(UserInfoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {
        Snackbar.make(mConstraintLayout,"please wait",Snackbar.LENGTH_LONG).show();
        //尝试使用SnackBar.make(父容器，弹出文本，时间).show
    }

    @Override
    public void dismissLoading() {
        Snackbar.make(mConstraintLayout,"load already",Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showUserInfo(UserInfoModel userInfoModel) {
        //回调的信息在activity上的应用
        if(userInfoModel != null){
            name.setText(userInfoModel.getName());
            //text中添加的内容一定是String类型的，记得要做类型转换
            age.setText(String.valueOf(userInfoModel.getAge()));
            address.setText(userInfoModel.getAddress());
        }
    }

    @Override
    public String loadUserId() {
        return "1000";
    }
}
