package com.zzb.googlemvppractice;

import android.app.Application;

import com.zzb.googlemvppractice.di.component.app.DaggerAppComponent;
import com.zzb.googlemvppractice.di.module.app.AppModule;

/**
 * Created by ZZB on 2016/10/11.
 */

public class MvpApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDI();
    }

    private void initDI() {
        DaggerAppComponent.builder().appModule(new AppModule(this)).build().inject(this);
    }
}
