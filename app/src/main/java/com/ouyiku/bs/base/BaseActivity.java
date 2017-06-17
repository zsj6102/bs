package com.ouyiku.bs.base;

import android.view.ViewGroup;

import com.ouyiku.bs.Util.SnackbarUtil;
import com.ouyiku.bs.app.App;
import com.ouyiku.bs.di.component.ActivityComponent;

import com.ouyiku.bs.di.component.DaggerActivityComponent;
import com.ouyiku.bs.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public abstract  class BaseActivity<T extends BasePresenter>  extends SimpleActivity implements BaseView{
    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }



    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    protected abstract void initInject();
}
