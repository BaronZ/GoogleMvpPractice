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
    private final List<User> mAddUsers = Collections.synchronizedList(new ArrayList<User>());
    private final List<User> mRemoveUsers = Collections.synchronizedList(new ArrayList<User>());
    private boolean mNeedUpdate = false;
//    private OnlineUsersCallback mOnlineUsersCallback;

    public OnlineUsersModel() {
    }

    public interface OnlineUsersCallback {
        void onOnlineUsersChanged(List<User> users);
    }

    //update online users every 1000 millis
    public void addUser(User user, OnlineUsersCallback callback) {
        mRemoveUsers.remove(user);
        if (!mOnlineUsers.contains(user)) {
            mAddUsers.add(user);
        }
        onOnlineUsersChanged(callback);
    }


    public void removeUser(User user, OnlineUsersCallback callback) {
        mAddUsers.remove(user);
        mRemoveUsers.add(user);
        onOnlineUsersChanged(callback);
    }

    public List<User> getOnlineUsers() {
        return mOnlineUsers;
    }

    // TODO: 2016/10/9 每秒更新一次，不每次来都更新
    private void onOnlineUsersChanged(OnlineUsersCallback callback) {
        mNeedUpdate = true;
        mOnlineUsers.removeAll(mRemoveUsers);
        mOnlineUsers.addAll(mAddUsers);
        if (callback != null) {
            callback.onOnlineUsersChanged(mOnlineUsers);
        }
        mNeedUpdate = false;
    }
}
