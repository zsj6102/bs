package com.ouyiku.bs.model.http;

import com.ouyiku.bs.model.bean.LoginBean;
import com.ouyiku.bs.model.http.api.LoginApi;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class RetrofitHelper implements HttpHelper {
    private LoginApi loginApi;
    @Inject
    public RetrofitHelper(LoginApi loginApi){
        this.loginApi = loginApi;
    }
    @Override
    public Flowable<LoginBean> getUserInfo(String url, String c, String a, String phone, String pwd) {
        return loginApi.getLoginInfo(url,c,a,phone,pwd);
    }
}
