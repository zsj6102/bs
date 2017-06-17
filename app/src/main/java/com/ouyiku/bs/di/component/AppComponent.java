package com.ouyiku.bs.di.component;

import com.ouyiku.bs.app.App;
import com.ouyiku.bs.di.module.AppModule;
import com.ouyiku.bs.di.module.HttpModule;
import com.ouyiku.bs.model.DataManager;
import com.ouyiku.bs.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类
}
