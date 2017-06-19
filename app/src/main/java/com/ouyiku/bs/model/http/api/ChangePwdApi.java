package com.ouyiku.bs.model.http.api;

import com.ouyiku.bs.model.bean.ChangPwdBean;
import com.ouyiku.bs.model.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public interface ChangePwdApi {
    /**
     * 启动界面图片
     */
    @GET
    Flowable<ChangPwdBean> getChange(@Url String url, @Query("c") String c, @Query("a") String a, @Query("mobile") String phone);
}
