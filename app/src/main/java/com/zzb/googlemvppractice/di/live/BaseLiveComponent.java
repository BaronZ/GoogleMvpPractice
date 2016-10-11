package com.zzb.googlemvppractice.di.live;

import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.model.live.LiveModel;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/11.
 */
@Component(modules = {BaseLiveModule.class})
public interface BaseLiveComponent {

    OnlineUsersContract.Presenter provideOnlineUsersPresenter();

    OnlineUsersModel provideOnlineUsersModel();

    LiveModel provideLiveModel();
}
