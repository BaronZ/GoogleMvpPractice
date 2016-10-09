package com.zzb.googlemvppractice.model.live;

import com.zzb.googlemvppractice.widget.OnlineUsersView;

/**
 * Created by ZZB on 2016/10/9.
 */

public class WatchLivePushController {


    private OnlineUsersView mOnlineUsersView;

    public WatchLivePushController() {
    }

    public void onReceivePushMessage(String message) {
        int code = message.hashCode();
        switch (code) {
            case 1:
                mOnlineUsersView.joinRoom(null);
                break;
            case 2:
                mOnlineUsersView.leaveRoom(null);
                break;
            case 3:
                mOnlineUsersView.onUserScoreChanged(null);
                break;
        }
    }

    public void setOnlineUsersView(OnlineUsersView onlineUsersView) {
        mOnlineUsersView = onlineUsersView;
    }

}
