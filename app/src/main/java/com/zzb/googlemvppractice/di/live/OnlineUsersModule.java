package com.zzb.googlemvppractice.di.live;

import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.model.live.LiveModel;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;
import com.zzb.googlemvppractice.presenter.online_users.OnlineUsersPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZZB on 2016/10/11.
 */
@Module
public class OnlineUsersModule {

    private OnlineUsersContract.View mOnlineUsersView;

    public OnlineUsersModule(OnlineUsersContract.View onlineUsersView) {
        mOnlineUsersView = onlineUsersView;
    }

    @Provides
    OnlineUsersContract.Presenter provideOnlineUsersPresenter(OnlineUsersModel onlineUsersModel, LiveModel liveModel) {
        return new OnlineUsersPresenter(mOnlineUsersView, onlineUsersModel, liveModel);
    }
    @Provides
    OnlineUsersModel provideOnlineUsersModel(LiveModel liveModel){
        return new OnlineUsersModel(liveModel);
    }
}
