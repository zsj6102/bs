package com.ouyiku.bs.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ouyiku.bs.R;
import com.ouyiku.bs.Util.ThemeUtils;
import com.ouyiku.bs.Util.VerifyUtil;
import com.ouyiku.bs.base.BaseActivity;
import com.ouyiku.bs.base.contract.login.LoginContract;
import com.ouyiku.bs.model.bean.LoginBean;
import com.ouyiku.bs.presenter.login.LoginPresenter;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.password)
    AutoRelativeLayout password;
    @BindView(R.id.pwdView)
    ImageView pwdView;
    @BindView(R.id.forgetPwd)
    TextView forgetPwd;

    @Override
    public void showContent(LoginBean bean) {
        if (bean.getStatus().getSucceed().equals("1")) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.login_btn)
    public void login() {
        if (!VerifyUtil.isMobile(phone.getText().toString())) {
            Toast.makeText(this, "请输入正确手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd.getText().toString())) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.getLoginData(phone.getText().toString(), pwd.getText().toString());
    }

    @OnClick(R.id.password)
    public void setPwdV() {
        TransformationMethod type = pwd.getTransformationMethod();

        if (PasswordTransformationMethod.getInstance().equals(type)) {
            pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            pwdView.setImageResource(R.mipmap.password_display_ico);
        } else {

            pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            pwdView.setImageResource(R.mipmap.password_cover_ico);
        }
    }

    @OnClick(R.id.forgetPwd)
    public void toForget() {
        Intent intent = new Intent(LoginActivity.this, ChangePwdActivity.class);
        startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return R.layout.login_activity;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        ButterKnife.bind(this);
//        StatusBarUtils.setWindowStatusBarColor(LoginActivity.this,"#fefefe");
        ThemeUtils.setStatusBarTheme(LoginActivity.this, R.color.mainColor);
        ThemeUtils.setStatusBarColor(LoginActivity.this, R.color.activity_bg);
    }
}
