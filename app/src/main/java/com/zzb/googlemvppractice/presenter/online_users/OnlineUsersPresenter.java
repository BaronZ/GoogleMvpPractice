package com.zzb.googlemvppractice.presenter.online_users;

import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract.Presenter;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersPresenter implements Presenter {

    private OnlineUsersContract.View mOnlineUsersView;
    private OnlineUsersModel mOnlineUsersModel;

    @Override
    public void joinRoom(User user) {
        mOnlineUsersModel.addUser(user);
//        mOnlineUsersView.updateOnlineUser(null);
    }

    @Override
    public void leaveRoom(User user) {
        mOnlineUsersModel.removeUser(user);
//        mOnlineUsersView.updateOnlineUser(null);
    }

    @Override
    public void start() {

    }
}
