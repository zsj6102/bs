package com.ouyiku.bs.model.http;

import com.ouyiku.bs.model.bean.LoginBean;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public interface HttpHelper {
    Flowable<LoginBean> getUserInfo(String url,String c,String a,String phone,String pwd);
}
