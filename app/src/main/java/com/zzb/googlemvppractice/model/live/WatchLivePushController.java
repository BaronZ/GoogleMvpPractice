package com.zzb.googlemvppractice.model.live;

import android.util.Log;

import com.zzb.googlemvppractice.contract.live.WatchLiveContact;
import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.entity.User;

import java.util.Random;

/**
 * Created by ZZB on 2016/10/9.
 */

public class WatchLivePushController {


    private OnlineUsersContract.Presenter mOnlineUsersPresenter;
    private WatchLiveContact.Presenter mWatchLivePresenter;

    public WatchLivePushController(OnlineUsersContract.Presenter onlineUsersPresenter, WatchLiveContact.Presenter watchLivePresenter) {
        mOnlineUsersPresenter = onlineUsersPresenter;
        mWatchLivePresenter = watchLivePresenter;
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


}
