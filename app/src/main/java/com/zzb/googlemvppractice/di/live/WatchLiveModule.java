package com.zzb.googlemvppractice.di.live;

import com.zzb.googlemvppractice.contract.live.WatchLiveContact;
import com.zzb.googlemvppractice.contract.live.WatchLiveContact.View;
import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.model.live.LiveModel;
import com.zzb.googlemvppractice.model.live.WatchLivePushController;
import com.zzb.googlemvppractice.presenter.live.WatchLivePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZZB on 2016/10/11.
 */
@Module
public class WatchLiveModule {

    private WatchLiveContact.View mWatchLiveView;

    public WatchLiveModule(View watchLiveView) {
        mWatchLiveView = watchLiveView;
    }

    @Provides
    WatchLiveContact.Presenter provideWatchLivePresenter(LiveModel liveModel) {
        return new WatchLivePresenter(liveModel, mWatchLiveView);
    }

    @Provides
    WatchLivePushController provideWatchLivePushController(OnlineUsersContract.Presenter onlineUsersPresenter, WatchLiveContact.Presenter watchLivePresenter) {
        return new WatchLivePushController(onlineUsersPresenter, watchLivePresenter);
    }



}
