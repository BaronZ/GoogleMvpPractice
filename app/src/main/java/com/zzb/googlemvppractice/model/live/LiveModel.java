package com.zzb.googlemvppractice.model.live;

import com.zzb.googlemvppractice.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZZB on 2016/10/10.
 */

public class LiveModel {

    private final Map<Long, Integer> mRankMap = new ConcurrentHashMap<>();

    public void getLiveShowData() {

    }

    public void updateRank(User... users) {

    }

    public int getRank(long uid) {
        return 0;
    }

    public void leaveLiveRoom() {

    }
}
