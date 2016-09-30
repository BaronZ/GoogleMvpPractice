package com.zzb.googlemvppractice.presenter.login;

import com.zzb.googlemvppractice.contract.login.PhoneLoginContract;
import com.zzb.googlemvppractice.contract.login.PhoneLoginContract.Presenter;
import com.zzb.googlemvppractice.contract.login.PhoneLoginContract.View;

/**
 * Created by ZZB on 2016/9/30.
 */

public class PhoneLoginPresenter implements Presenter {

    private PhoneLoginContract.View mPhoneLoginView;

    public PhoneLoginPresenter(View phoneLoginView) {
        mPhoneLoginView = phoneLoginView;
        mPhoneLoginView.setPresenter(this);
    }

    @Override
    public void login(String phone, String psw) {
        mPhoneLoginView.showLoginDialog();
        if ("123".equals(phone) && "123".equals(psw)) {
            mPhoneLoginView.showLoginSuccess();
        } else {
            mPhoneLoginView.showLoginError();
        }
        mPhoneLoginView.hideLoginDialog();

    }

    @Override
    public void start() {

    }
}
