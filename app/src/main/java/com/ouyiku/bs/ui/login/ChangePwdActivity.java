package com.ouyiku.bs.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ouyiku.bs.R;
import com.ouyiku.bs.Util.ThemeUtils;
import com.ouyiku.bs.Util.VerifyUtil;
import com.ouyiku.bs.base.BaseActivity;
import com.ouyiku.bs.base.contract.login.ChangePwdContract;
import com.ouyiku.bs.model.bean.ChangPwdBean;
import com.ouyiku.bs.presenter.changepwd.ChangePwdPresenter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class ChangePwdActivity extends BaseActivity<ChangePwdPresenter> implements ChangePwdContract.View {
    @BindView(R.id.bc_layout)
    AutoLinearLayout bcLayout;
    @BindView(R.id.com_toolbar)
    AutoRelativeLayout comToolbar;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.sendCode)
    TextView sendCode;
    @BindView(R.id.code_layout)
    AutoRelativeLayout codeLayout;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.submit_btn)
    Button submitBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
//        StatusBarUtils.setWindowStatusBarColor(LoginActivity.this,"#fefefe");
        ThemeUtils.setStatusBarTheme(ChangePwdActivity.this, R.color.mainColor);
        ThemeUtils.setStatusBarColor(ChangePwdActivity.this, R.color.mainColor);
    }

    @Override
    public void showResult(ChangPwdBean bean) {
        String sc =  bean.getStatus().getSucceed();
        if(bean.getData().getStatus().equals("2")){
            Toast.makeText(this,"号码不存在",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.bc_layout)
    public void back() {
        this.finish();
    }
    @OnClick(R.id.code_layout)
    public void sendPhone(){
        if(!VerifyUtil.isMobile(phone.getText().toString())){
            Toast.makeText(this,"号码不正确,请重新输入",Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.getSms(phone.getText().toString());
    }
    @Override
    protected int getLayout() {
        return R.layout.change_pwd;
    }

    @Override
    protected void initEventAndData() {

    }
}
