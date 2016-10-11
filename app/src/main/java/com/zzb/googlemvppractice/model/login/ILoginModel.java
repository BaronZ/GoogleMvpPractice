package com.zzb.googlemvppractice.model.login;

import com.zzb.googlemvppractice.entity.User;

import rx.Observable;

/**
 * Created by ZZB on 2016/10/11.
 */

public interface ILoginModel {

    Observable<User> phoneLogin(String phone, String psw);

    void logout();
}
