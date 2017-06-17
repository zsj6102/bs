package com.ouyiku.bs.presenter.login;

import com.ouyiku.bs.Util.RxUtil;
import com.ouyiku.bs.base.RxPresenter;
import com.ouyiku.bs.base.contract.login.LoginContract;
import com.ouyiku.bs.model.DataManager;
import com.ouyiku.bs.model.bean.LoginBean;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class LoginPresenter  extends RxPresenter<LoginContract.View> implements LoginContract.Presenter{
    private DataManager mDataManager;
    private String suc;
    @Inject
    public LoginPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }
    @Override
    public void getLoginData() {
        addSubscribe(mDataManager.getUserInfo("http://a.ouyiku.com/","Seller","login","13015559826","wanmei888")
                        .compose(RxUtil.<LoginBean>rxSchedulerHelper())
                        .subscribe(new Consumer<LoginBean>() {
                            @Override
                            public void accept(LoginBean welcomeBean) {
                                suc = welcomeBean.getStatus().getSucceed();
                                mView.showContent(welcomeBean);
//                                startCountDown();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) {
//                        mView.jumpToMain();
                            }
                        })
        );
    }
}
