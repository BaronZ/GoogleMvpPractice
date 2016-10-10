package com.zzb.googlemvppractice.contract.live;

import com.zzb.googlemvppractice.BasePresenter;
import com.zzb.googlemvppractice.BaseView;
import com.zzb.googlemvppractice.entity.User;

/**
 * Created by ZZB on 2016/10/10.
 */

public class WatchLiveContact {


    public interface View extends BaseView {

        void onGetLiveShowDataSuccess();

        void onGetLiveShowDataFailed();

        void onRankChanged(User user);

    }

    public interface Presenter extends BasePresenter {

        void getLiveShowData();

        void leaveLiveRoom();

        void updateRank(User... users);
    }
}
