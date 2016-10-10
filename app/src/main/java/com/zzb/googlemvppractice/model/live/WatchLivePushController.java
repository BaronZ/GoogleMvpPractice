package com.zzb.googlemvppractice.model.live;

import android.util.Log;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.presenter.live.WatchLivePresenter;
import com.zzb.googlemvppractice.presenter.online_users.OnlineUsersPresenter;

import java.util.Random;

/**
 * Created by ZZB on 2016/10/9.
 */

public class WatchLivePushController {


    //    private OnlineUsersView mOnlineUsersView;
    private OnlineUsersPresenter mOnlineUsersPresenter;
    private WatchLivePresenter mWatchLivePresenter;

    public WatchLivePushController() {
    }

    public void onReceivePushMessage(String message) {
        int code = Integer.valueOf(message);
        switch (code) {
            case 1:
                mOnlineUsersPresenter.joinRoom(getRandomUser());
                break;
            case 2:
                mOnlineUsersPresenter.leaveRoom(getRandomUser());
                break;
            case 3:
                mWatchLivePresenter.updateRank(getRandomUser());
                break;
        }
    }

    private User getRandomUser() {
        Random random = new Random();
        int id = random.nextInt(10);
        User user = new User(id);
        user.setScore(random.nextInt(10));
        Log.d("zzb", "user:" + user.toString());
        return user;
    }

    public void setOnlineUsersPresenter(OnlineUsersPresenter onlineUsersPresenter) {
        mOnlineUsersPresenter = onlineUsersPresenter;
    }

    public void setWatchLivePresenter(WatchLivePresenter watchLivePresenter) {
        mWatchLivePresenter = watchLivePresenter;
    }
}
