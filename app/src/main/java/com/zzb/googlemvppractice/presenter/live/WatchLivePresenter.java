package com.zzb.googlemvppractice.presenter.live;

import com.zzb.googlemvppractice.contract.live.WatchLiveContact;
import com.zzb.googlemvppractice.contract.live.WatchLiveContact.View;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.live.LiveModel;

/**
 * Created by ZZB on 2016/10/10.
 */

public class WatchLivePresenter implements WatchLiveContact.Presenter {

    private LiveModel mLiveModel;
    private WatchLiveContact.View mWatchLiveView;

    public WatchLivePresenter(LiveModel liveModel, View watchLiveView) {
        mLiveModel = liveModel;
        mWatchLiveView = watchLiveView;
    }

    @Override
    public void getLiveShowData() {
        mLiveModel.updateRank();
        mWatchLiveView.onRankChanged(null);
    }

    @Override
    public void leaveLiveRoom() {

    }

    @Override
    public void updateRank(User... users) {
        mLiveModel.updateRank(users);
    }
}
