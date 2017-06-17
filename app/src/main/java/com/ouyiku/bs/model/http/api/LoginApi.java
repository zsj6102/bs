package com.ouyiku.bs.model.http.api;

import com.ouyiku.bs.model.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public interface LoginApi {
    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 启动界面图片
     */
    @GET
    Flowable<LoginBean> getLoginInfo(@Url String url, @Query("c") String c,@Query("a") String a,@Query("phone") String phone,@Query("pwd") String pwd);

}
