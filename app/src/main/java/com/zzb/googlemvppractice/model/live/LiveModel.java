package com.zzb.googlemvppractice.model.live;

import com.zzb.googlemvppractice.entity.User;

import java.util.List;

/**
 * Created by ZZB on 2016/10/10.
 */

public class LiveModel {

    private RankModel mRankModel;

    public LiveModel() {
        mRankModel = new RankModel();
    }

    public void getLiveShowData() {

    }

    public void updateRank(User... users) {
        mRankModel.updateRank(users);
    }

    public void updateRank(List<User> users) {
        mRankModel.updateRank(users);
    }

    public int getRank(long uid){
        return mRankModel.getRank(uid);
    }
    public void leaveLiveRoom() {
        mRankModel.clear();
    }
}
