package com.ouyiku.bs.di.component;

import android.app.Activity;


import com.ouyiku.bs.di.module.ActivityModule;
import com.ouyiku.bs.di.scope.ActivityScope;
import com.ouyiku.bs.ui.login.ChangePwdActivity;
import com.ouyiku.bs.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(LoginActivity loginActivity);
    void inject(ChangePwdActivity changePwdActivity);

}
