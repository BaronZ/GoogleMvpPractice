package com.zzb.googlemvppractice;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.zzb.googlemvppractice.di.component.app.AppComponent;
import com.zzb.googlemvppractice.di.component.app.DaggerAppComponent;
import com.zzb.googlemvppractice.di.module.app.AppModule;

/**
 * Created by ZZB on 2016/10/11.
 */

public class MvpApplication extends Application {
    private AppComponent mAppComponent;

    private static MvpApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        initDI();
        initLeakCanary();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void initDI() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.inject(this);
    }

    public static MvpApplication getApplication() {
        return sApplication;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
