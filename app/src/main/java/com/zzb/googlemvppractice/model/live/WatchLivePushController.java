package com.zzb.googlemvppractice.model.live;

import android.util.Log;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.widget.OnlineUsersView;

import java.util.Random;

/**
 * Created by ZZB on 2016/10/9.
 */

public class WatchLivePushController {


    private OnlineUsersView mOnlineUsersView;

    public WatchLivePushController() {
    }

    public void onReceivePushMessage(String message) {
        int code = Integer.valueOf(message);
        switch (code) {
            case 1:
                mOnlineUsersView.joinRoom(getRandomUser());
                break;
            case 2:
                mOnlineUsersView.leaveRoom(getRandomUser());
                break;
            case 3:
                mOnlineUsersView.onUserScoreChanged(getRandomUser());
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

    public void setOnlineUsersView(OnlineUsersView onlineUsersView) {
        mOnlineUsersView = onlineUsersView;
    }

}
