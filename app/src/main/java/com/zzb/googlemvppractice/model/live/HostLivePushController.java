package com.zzb.googlemvppractice.model.live;

import com.zzb.googlemvppractice.presenter.online_users.OnlineUsersPresenter;

/**
 * Created by ZZB on 2016/10/9.
 */

public class HostLivePushController {

    private OnlineUsersPresenter mOnlineUsersPresenter;

    public HostLivePushController() {
    }

    public void onReceivePushMessage(String message) {
        int code = message.hashCode();
        switch (code) {
            case 1:
                mOnlineUsersPresenter.joinRoom(null);
                break;
            case 2:
                mOnlineUsersPresenter.leaveRoom(null);
                break;
        }
    }

    public void setOnlineUsersPresenter(OnlineUsersPresenter presenter) {
        mOnlineUsersPresenter = presenter;
    }


}
