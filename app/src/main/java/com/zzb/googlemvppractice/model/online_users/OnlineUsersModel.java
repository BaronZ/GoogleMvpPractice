package com.zzb.googlemvppractice.model.online_users;

import com.zzb.googlemvppractice.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersModel {
    private static final long UPDATE_LIST_INTERVAL_IN_MILLIS = 1000;
    private final List<User> mOnlineUsers = Collections.synchronizedList(new ArrayList<User>());

    //update online users every 1000 millis
    public void addUser(User user) {

    }

    public void removeUser(User user) {

    }

    public List<User> getOnlineUsers() {
        return mOnlineUsers;
    }
}
