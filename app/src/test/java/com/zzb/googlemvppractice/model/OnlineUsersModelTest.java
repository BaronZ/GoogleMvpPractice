package com.zzb.googlemvppractice.model;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersModelTest {
    private OnlineUsersModel mOnlineUsersModel;

    @Before
    public void setUp() {
        mOnlineUsersModel = new OnlineUsersModel();
    }

    @Test
    public void null_test() {
        mOnlineUsersModel.addUser(null, null);
        mOnlineUsersModel.removeUser(null, null);
    }

    @Test
    public void size_test() {
        User user = new User(1);
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
    public void add_test() {
        User user1 = new User(1);
        addUser(user1);
        addUser(user1);
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().contains(user1));
        Assert.assertTrue(mOnlineUsersModel.getOnlineUsers().size() == 1);
    }

    private void addUser(User user) {
        mOnlineUsersModel.addUser(user, null);
    }

    private void removeUser(User user) {
        mOnlineUsersModel.removeUser(user, null);
    }
}
