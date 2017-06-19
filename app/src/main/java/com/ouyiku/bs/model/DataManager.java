package com.ouyiku.bs.model;

import com.ouyiku.bs.model.bean.ChangPwdBean;
import com.ouyiku.bs.model.bean.LoginBean;
import com.ouyiku.bs.model.http.HttpHelper;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class DataManager implements HttpHelper{
    HttpHelper mHttpHelper;
    public DataManager(HttpHelper httpHelper){
        mHttpHelper = httpHelper;
    }
    @Override
    public Flowable<LoginBean> getUserInfo(String url, String c, String a, String phone, String pwd) {
         return mHttpHelper.getUserInfo(url,c,a,phone,pwd);
    }

    @Override
    public Flowable<ChangPwdBean> getSmsInfo(String url, String c, String a, String phone) {
        return mHttpHelper.getSmsInfo(url,c,a,phone);
    }
}
