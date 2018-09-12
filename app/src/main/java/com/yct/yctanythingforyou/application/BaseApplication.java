package com.yct.yctanythingforyou.application;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication baseApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static BaseApplication getInstance() {
        return baseApplication;
    }
}
