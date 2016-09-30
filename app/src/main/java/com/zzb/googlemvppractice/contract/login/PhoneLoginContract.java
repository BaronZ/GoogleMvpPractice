package com.zzb.googlemvppractice.contract.login;

import com.zzb.googlemvppractice.BasePresenter;
import com.zzb.googlemvppractice.BaseView;

/**
 * Created by ZZB on 2016/9/30.
 */

public class PhoneLoginContract {


    public interface View extends BaseView<Presenter> {
        void showLoginDialog();

        void showLoginSuccess();

        void showLoginError();

        void hideLoginDialog();

        void isActive();
    }

    public interface Presenter extends BasePresenter {

        void login(String phone, String psw);
    }
}
