package com.zzb.googlemvppractice.di.component.live;

import com.zzb.googlemvppractice.activity.live.WatchLiveActivity;
import com.zzb.googlemvppractice.di.module.live.WatchLiveModule;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/11.
 */
@Component(dependencies = {BaseLiveComponent.class}, modules = {WatchLiveModule.class})
//@Component(modules = {OnlineUsersModule.class, WatchLiveModule.class})
public interface WatchLiveComponent {

    void inject(WatchLiveActivity activity);

}
