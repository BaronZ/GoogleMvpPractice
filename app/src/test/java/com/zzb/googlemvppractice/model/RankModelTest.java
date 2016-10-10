package com.zzb.googlemvppractice.model;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.live.RankModel;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ZZB on 2016/10/10.
 */

public class RankModelTest {
    private RankModel mRankModel;

    @Before
    public void setUp() {
        mRankModel = new RankModel();
    }

    @Test
    public void single_update() {
        long uid1 = 1, uid2 = 2;
        int score1 = 1, score2 = 2;
        List<User> users1 = Arrays.asList(new User(uid1, score1), new User(uid2, score2));
        mRankModel.updateRank(users1);
        Assert.assertEquals(score1, mRankModel.getRank(uid1));
        Assert.assertEquals(score2, mRankModel.getRank(uid2));

    }

    @Test
    public void duplicate_update() {
        long uid1 = 1, uid2 = 2, uid3 = 3, uid4 = 4;
        int score1 = 1, score2 = 2, score3 = 3, score4 = 4;
        List<User> users1 = Arrays.asList(new User(uid1, score1), new User(uid2, score2));
        List<User> users2 = Arrays.asList(new User(uid4, score4), new User(uid3, score3));
        mRankModel.updateRank(users1);
        Assert.assertEquals(score1, mRankModel.getRank(uid1));
        Assert.assertEquals(score2, mRankModel.getRank(uid2));
        mRankModel.updateRank(users2);
        Assert.assertEquals(score1, mRankModel.getRank(uid1));
        Assert.assertEquals(score2, mRankModel.getRank(uid2));
        Assert.assertEquals(score3, mRankModel.getRank(uid3));
        Assert.assertEquals(score4, mRankModel.getRank(uid4));
    }


}
