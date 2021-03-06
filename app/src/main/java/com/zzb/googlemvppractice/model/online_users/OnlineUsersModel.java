package com.zzb.googlemvppractice.model.online_users;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.live.LiveModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersModel {
    private static final long UPDATE_LIST_INTERVAL_IN_MILLIS = 1000;
    private LiveModel mLiveModel;
    private final List<User> mOnlineUsers = Collections.synchronizedList(new ArrayList<User>());
    private final List<User> mAddUsers = Collections.synchronizedList(new ArrayList<User>());
    private final List<User> mRemoveUsers = Collections.synchronizedList(new ArrayList<User>());
    private boolean mNeedUpdate = false;
//    private OnlineUsersCallback mOnlineUsersCallback;

    public OnlineUsersModel(LiveModel liveModel) {
        mLiveModel = liveModel;
    }

    public interface OnlineUsersCallback {
        void onOnlineUsersChanged(List<User> users);
    }

    //update online users every 1000 millis
    public void addOrUpdateUser(User user, OnlineUsersCallback callback) {
        mRemoveUsers.remove(user);
        if (mAddUsers.contains(user)) {
            mAddUsers.remove(user);
        }
        if (mOnlineUsers.contains(user)) {
            mOnlineUsers.remove(user);
        }
        mAddUsers.add(user);
        onOnlineUsersChanged(callback);
    }


    public void removeUser(User user, OnlineUsersCallback callback) {
        mAddUsers.remove(user);
        if (!mRemoveUsers.contains(user)) {
            mRemoveUsers.add(user);
        }
        onOnlineUsersChanged(callback);
    }

    public void selfLeaveRoom(OnlineUsersCallback callback) {
        mAddUsers.clear();
        mRemoveUsers.clear();
        mOnlineUsers.clear();
        mNeedUpdate = false;
        if (callback != null) {
            callback.onOnlineUsersChanged(null);
        }
    }

    public void updateOnlineUsersRank(OnlineUsersCallback callback) {
        if (mOnlineUsers == null) {
            return;
        }
        for (User user : mOnlineUsers) {
            user.setRank(mLiveModel.getRank(user.getUid()));
        }
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
        mRemoveUsers.clear();
        mAddUsers.clear();
        sortOnlineUsers();
        if (callback != null) {
            callback.onOnlineUsersChanged(mOnlineUsers);
        }
        mNeedUpdate = false;
    }

    private void sortOnlineUsers() {

    }
}
