package com.ouyiku.bs.presenter.changepwd;

import com.ouyiku.bs.Util.RxUtil;
import com.ouyiku.bs.base.RxPresenter;
import com.ouyiku.bs.base.contract.login.ChangePwdContract;
import com.ouyiku.bs.model.DataManager;
import com.ouyiku.bs.model.bean.ChangPwdBean;


import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class ChangePwdPresenter extends RxPresenter<ChangePwdContract.View> implements ChangePwdContract.Presenter{
    private DataManager mDataManager;

    @Inject
    public ChangePwdPresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }
    @Override
    public void getSms(String phone) {
        addSubscribe(mDataManager.getSmsInfo("http://a.ouyiku.com/","Seller","getcode",phone)
                        .compose(RxUtil.<ChangPwdBean>rxSchedulerHelper())
                        .subscribe(new Consumer<ChangPwdBean>() {
                            @Override
                            public void accept(ChangPwdBean welcomeBean) {
                                mView.showResult(welcomeBean);

                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) {
                            }
                        })
        );
    }
}
