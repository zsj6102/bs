package com.ouyiku.bs.di.module;

import com.ouyiku.bs.app.App;
import com.ouyiku.bs.model.DataManager;
import com.ouyiku.bs.model.http.HttpHelper;
import com.ouyiku.bs.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/6/17 0017.
 */
@Module
public class AppModule {
    private final App application;
    public AppModule(App application){
        this.application = application;
    }
    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }
    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }
    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
}
