package com.zzb.googlemvppractice.di.live.component;

import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.di.live.module.BaseLiveModule;
import com.zzb.googlemvppractice.model.live.LiveModel;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/11.
 */
@Component(modules = {BaseLiveModule.class})
public interface BaseLiveComponent {
    //component提供方法，给依赖的人用
    OnlineUsersContract.Presenter provideOnlineUsersPresenter();
    //这里暂时没有调用，所以是灰的。其他的方法，WatchLiveModule都调用了，所以不是灰的
    OnlineUsersModel provideOnlineUsersModel();

    LiveModel provideLiveModel();
}
