package com.zzb.googlemvppractice.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract.Presenter;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;
import com.zzb.googlemvppractice.presenter.online_users.OnlineUsersPresenter;

import java.util.List;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersView extends FrameLayout implements OnlineUsersContract.View {

    private OnlineUsersPresenter mOnlineUsersPresenter;

    public OnlineUsersView(Context context) {
        super(context);
    }

    public OnlineUsersView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OnlineUsersView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(OnlineUsersModel onlineUsersModel) {
        mOnlineUsersPresenter = new OnlineUsersPresenter(this, onlineUsersModel);
    }

    @Override
    public void updateOnlineUsers(List<User> onlineUsers) {
        //update ui
    }

    //=============presenter start
    public void onUserScoreChanged(User user) {
        mOnlineUsersPresenter.userScoreChanged(user);
    }

    public void joinRoom(User user) {
        mOnlineUsersPresenter.joinRoom(user);
    }

    public void leaveRoom(User user) {
        mOnlineUsersPresenter.leaveRoom(user);
    }

    public void selfLeaveRoom() {
        mOnlineUsersPresenter.selfLeaveRoom();
    }

    //============presenter end
    @Override
    public void setPresenter(Presenter presenter) {
        mOnlineUsersPresenter = (OnlineUsersPresenter) presenter;
    }


}
