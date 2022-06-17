package com.example.meetandmeet;
/// 코드 작성자 2019038084 이민희 ///
import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;


public class KakaoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "71a2ce3e4820ac98b623253291f34d07");
    }
}
