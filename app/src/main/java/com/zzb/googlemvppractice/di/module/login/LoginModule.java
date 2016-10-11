package com.zzb.googlemvppractice.di.module.login;

import com.zzb.googlemvppractice.contract.login.PhoneLoginContract;
import com.zzb.googlemvppractice.contract.login.PhoneLoginContract.View;
import com.zzb.googlemvppractice.model.login.ILoginModel;
import com.zzb.googlemvppractice.model.login.LoginModel;
import com.zzb.googlemvppractice.model.user.UserModel;
import com.zzb.googlemvppractice.presenter.login.PhoneLoginPresenter;
import com.zzb.googlemvppractice.util.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZZB on 2016/10/11.
 */
@Module
public class LoginModule {
    private PhoneLoginContract.View mPhoneLoginView;

    public LoginModule(View phoneLoginView) {
        mPhoneLoginView = phoneLoginView;
    }

    @Provides
    ILoginModel provideLoginModel(UserModel userModel) {
        return new LoginModel(userModel);
    }

    @Provides
    PhoneLoginContract.Presenter providePhoneLoginPresenter(ILoginModel loginModel, BaseSchedulerProvider schedulerProvider) {
        return new PhoneLoginPresenter(mPhoneLoginView, loginModel, schedulerProvider);
    }
}
