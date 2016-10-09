package com.zzb.googlemvppractice.contract.online_users;

import com.zzb.googlemvppractice.BasePresenter;
import com.zzb.googlemvppractice.BaseView;
import com.zzb.googlemvppractice.entity.User;

import java.util.List;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersContract {

    public interface View extends BaseView<Presenter> {
        void updateOnlineUser(List<User> users);
    }

    public interface Presenter extends BasePresenter {

        void joinRoom(User user);

        void leaveRoom(User user);
    }
}
