package com.ouyiku.bs.base.contract.login;

import com.ouyiku.bs.base.BasePresenter;
import com.ouyiku.bs.base.BaseView;
import com.ouyiku.bs.model.bean.LoginBean;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public interface LoginContract {
    interface View extends BaseView {
        void showContent(LoginBean bean);
    }
    interface Presenter extends BasePresenter<View>{
        void getLoginData();
    }
}
