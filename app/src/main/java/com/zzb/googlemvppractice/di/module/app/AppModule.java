package com.zzb.googlemvppractice.di.module.app;

import android.app.Application;
import android.content.Context;

import com.zzb.googlemvppractice.di.qualifier.ApplicationContext;
import com.zzb.googlemvppractice.model.user.UserModel;
import com.zzb.googlemvppractice.util.schedulers.BaseSchedulerProvider;
import com.zzb.googlemvppractice.util.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZZB on 2016/10/11.
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context getAppContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    @Provides
    @Singleton
    UserModel provideUserModel() {
        return new UserModel();
    }
}
