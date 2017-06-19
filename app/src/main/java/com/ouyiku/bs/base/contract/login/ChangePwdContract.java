package com.ouyiku.bs.base.contract.login;

import com.ouyiku.bs.base.BasePresenter;
import com.ouyiku.bs.base.BaseView;
import com.ouyiku.bs.model.bean.ChangPwdBean;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public interface ChangePwdContract {
    interface View extends BaseView {
         void showResult(ChangPwdBean bean);
    }
    interface Presenter extends BasePresenter<View>{
        void getSms(String phone);
    }
}
