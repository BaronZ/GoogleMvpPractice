package com.zzb.googlemvppractice.presenter.online_users;

import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract.Presenter;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.live.LiveModel;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel.OnlineUsersCallback;

import java.util.List;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersPresenter implements Presenter, OnlineUsersCallback {

    private OnlineUsersContract.View mOnlineUsersView;
    private OnlineUsersModel mOnlineUsersModel;
    private LiveModel mLiveModel;



    public OnlineUsersPresenter(OnlineUsersContract.View onlineUsersView, OnlineUsersModel onlineUsersModel, LiveModel liveModel) {
        mOnlineUsersView = onlineUsersView;
        mOnlineUsersModel = onlineUsersModel;
        mLiveModel = liveModel;
    }

    @Override
    public void joinRoom(User user) {
        if (user != null) {
            user.setRank(mLiveModel.getRank(user.getUid()));
            mOnlineUsersModel.addOrUpdateUser(user, this);
        }
    }

    @Override
    public void leaveRoom(User user) {
        mOnlineUsersModel.removeUser(user, this);
    }

    @Override
    public void selfLeaveRoom() {
        mOnlineUsersModel.selfLeaveRoom(this);
    }

    @Override
    public void userScoreChanged(User user) {
        mLiveModel.updateRank(user);
        mOnlineUsersModel.updateOnlineUsersRank(this);
    }


    @Override
    public void onOnlineUsersChanged(List<User> users) {
        mOnlineUsersView.updateOnlineUsers(users);
    }


}
