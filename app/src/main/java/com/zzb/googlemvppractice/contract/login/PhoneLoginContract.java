package com.zzb.googlemvppractice.contract.login;

import com.zzb.googlemvppractice.BasePresenter;
import com.zzb.googlemvppractice.BaseView;
import com.zzb.googlemvppractice.entity.User;

/**
 * Created by ZZB on 2016/9/30.
 */

public class PhoneLoginContract {


    public interface View extends BaseView<Presenter> {
        void showLoginDialog();

        void showLoginSuccess(User user);

        void showLoginError(String msg);

        void hideLoginDialog();

        void isActive();
    }

    public interface Presenter extends BasePresenter {

        void login(String phone, String psw);
    }
}
