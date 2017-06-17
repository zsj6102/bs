package com.ouyiku.bs.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017/6/17 0017.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface LoginUrl {

}