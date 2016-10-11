package com.zzb.googlemvppractice.model.user;

import com.zzb.googlemvppractice.entity.User;

/**
 * Created by ZZB on 2016/10/11.
 */

public class UserModel {

    private User mLoginUser = new User();

    public void updateUserInfo(long uid, String nick) {
        mLoginUser.setUid(uid);
        mLoginUser.setNick(nick);
    }

    public User getUserInfo() {
        return mLoginUser;
    }

    public void clear() {
        mLoginUser = new User();
    }
}
