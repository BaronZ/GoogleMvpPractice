package com.zzb.googlemvppractice.presenter.login;

import com.zzb.googlemvppractice.contract.login.PhoneLoginContract;
import com.zzb.googlemvppractice.contract.login.PhoneLoginContract.Presenter;
import com.zzb.googlemvppractice.contract.login.PhoneLoginContract.View;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.login.ILoginModel;
import com.zzb.googlemvppractice.util.schedulers.BaseSchedulerProvider;

import rx.Subscriber;

/**
 * Created by ZZB on 2016/9/30.
 */

public class PhoneLoginPresenter implements Presenter {

    private PhoneLoginContract.View mPhoneLoginView;
    private ILoginModel mLoginModel;
    private BaseSchedulerProvider mSchedulerProvider;

    public PhoneLoginPresenter(View phoneLoginView, ILoginModel loginModel, BaseSchedulerProvider schedulerProvider) {
        mPhoneLoginView = phoneLoginView;
        mLoginModel = loginModel;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void login(String phone, String psw) {
        mPhoneLoginView.showLoginDialog();
        mLoginModel.phoneLogin(phone, psw)
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                        mPhoneLoginView.hideLoginDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mPhoneLoginView.showLoginError(e.getMessage());
                        mPhoneLoginView.hideLoginDialog();
                    }

                    @Override
                    public void onNext(User user) {
                        mPhoneLoginView.showLoginSuccess(user);
                    }
                });
    }


}
