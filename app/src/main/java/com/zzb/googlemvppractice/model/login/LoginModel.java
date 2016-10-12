package com.zzb.googlemvppractice.model.login;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.user.UserModel;

import java.util.Random;

import rx.Observable;

/**
 * Created by ZZB on 2016/10/11.
 */

public class LoginModel implements ILoginModel {

    private UserModel mUserModel;

    public LoginModel(UserModel userModel) {
        mUserModel = userModel;
    }

    @Override
    public Observable<User> phoneLogin(String phone, String psw) {

        User user = new User();
        if ("1".equals(psw)) {
            user.setUid(new Random().nextInt(10));
            user.setNick(phone);
            mUserModel.updateUserInfo(user.getUid(), phone);
            return Observable.just(user);//.delay(3, TimeUnit.SECONDS);
        } else {
            return Observable.error(new RuntimeException("wrong password， correct password is 1"));
        }
    }

    @Override
    public void logout() {
        mUserModel.clear();
    }

}
