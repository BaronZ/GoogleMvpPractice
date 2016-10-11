package com.zzb.googlemvppractice.di.component.login;

import com.zzb.googlemvppractice.activity.login.LoginActivity;
import com.zzb.googlemvppractice.di.component.app.AppComponent;
import com.zzb.googlemvppractice.di.module.login.LoginModule;
import com.zzb.googlemvppractice.di.qualifier.PerActivity;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/11.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);
}
