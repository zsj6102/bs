package com.ouyiku.bs.Util;

import android.text.TextUtils;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class VerifyUtil {
    public static boolean isMobile(String number) {
        String num = "[1][358]\\d{9}";
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            return number.matches(num);
        }
    }

}
