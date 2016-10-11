package com.zzb.googlemvppractice.di.component.app;

import com.zzb.googlemvppractice.MvpApplication;
import com.zzb.googlemvppractice.di.module.app.AppModule;
import com.zzb.googlemvppractice.model.user.UserModel;
import com.zzb.googlemvppractice.util.schedulers.BaseSchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/11.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MvpApplication application);

    BaseSchedulerProvider provideSchedulerProvider();

    UserModel provideUserModel();
}
