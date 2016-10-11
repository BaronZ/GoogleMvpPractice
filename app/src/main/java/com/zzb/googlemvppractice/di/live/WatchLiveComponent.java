package com.zzb.googlemvppractice.di.live;

import com.zzb.googlemvppractice.activity.live.WatchLiveActivity;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/11.
 */
//@Component(dependencies = {LiveComponent.class}, modules = {WatchLiveModule.class})
@Component(modules = {OnlineUsersModule.class, WatchLiveModule.class})
public interface WatchLiveComponent {

    void inject(WatchLiveActivity activity);

}
