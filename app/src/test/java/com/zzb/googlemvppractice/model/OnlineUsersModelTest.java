package com.zzb.googlemvppractice.model;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.live.LiveModel;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersModelTest {
    private OnlineUsersModel mOnlineUsersModel;
    private LiveModel mLiveModel;
    @Before
    public void setUp() {
        mLiveModel = new LiveModel();
        mOnlineUsersModel = new OnlineUsersModel(mLiveModel);
    }

    @Test
    public void null_test() {
        mOnlineUsersModel.addOrUpdateUser(null, null);
        mOnlineUsersModel.removeUser(null, null);
    }

    @Test
    public void size_test() {
        User user = new User(1);

        addUser(user);
        Assert.assertEquals(1, mOnlineUsersModel.getOnlineUsers().size());

        removeUser(user);
        Assert.assertEquals(0, mOnlineUsersModel.getOnlineUsers().size());

        addUser(user);
        removeUser(user);
        Assert.assertEquals(0, mOnlineUsersModel.getOnlineUsers().size());
    }

    @Test
    public void remove_test() {
        removeUser(null);
        removeUser(new User(1));
    }

    @Test
    public void remove_add_remove_add() {
        User user1 = new User(1);
        removeUser(user1);
        addUser(user1);
        removeUser(user1);
        addUser(user1);
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().contains(user1));
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().size() == 1);
    }

    @Test
    public void duplicate_add_test() {
        User user1 = new User(1);
        addUser(user1);
        addUser(user1);
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().contains(user1));
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().size() == 1);
    }

    @Test
    public void add_diff_user_test() {
        User user1 = new User(1);
        User user2 = new User(2);
        addUser(user1);
        addUser(user2);
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().contains(user1));
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().contains(user2));
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().size() == 2);

    }

    private void addUser(User user) {
        mOnlineUsersModel.addOrUpdateUser(user, null);
    }

    private void removeUser(User user) {
        mOnlineUsersModel.removeUser(user, null);
    }
}
