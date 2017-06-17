package com.ouyiku.bs.ui.login;

import android.widget.Toast;

import com.ouyiku.bs.R;
import com.ouyiku.bs.base.BaseActivity;
import com.ouyiku.bs.base.contract.login.LoginContract;
import com.ouyiku.bs.model.bean.LoginBean;
import com.ouyiku.bs.presenter.login.LoginPresenter;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
    @Override
    public void showContent(LoginBean bean) {
           if(bean.getStatus().getSucceed().equals("1")){
               Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
           }
    }

    @Override
    protected int getLayout() {
        return R.layout.login_activity;
    }

    @Override
    protected void initEventAndData() {
          mPresenter.getLoginData();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
