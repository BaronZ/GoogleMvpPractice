package com.zzb.googlemvppractice.model.live;

import com.zzb.googlemvppractice.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ZZB on 2016/10/10.
 */

public class LiveModel {

    private final Map<Long, Integer> mRankMap = new ConcurrentHashMap<>();
    private final List<User> mRankUsers = Collections.synchronizedList(new ArrayList<User>());

    public void getLiveShowData() {

    }

    public void updateRank(User... users) {
        if (users == null) {
            return;
        }
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            userList.add(user);
        }
        updateRank(userList);
    }

    public void updateRank(List<User> users) {
        if (users == null) {
            return;
        }
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (mRankUsers.contains(user)) {
                it.remove();
            }
        }
        mRankUsers.addAll(users);
        sortRank();
    }

    private void sortRank() {
        mRankMap.clear();
        Collections.sort(mRankUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        for (int i = 0; i < mRankUsers.size(); i++) {
            User user = mRankUsers.get(i);
            mRankMap.put(user.getUid(), i + 1);
        }

    }

    public int getRank(long uid) {
        Integer rank = mRankMap.get(uid);
        return rank != null ? rank : 0;
    }

    public void leaveLiveRoom() {
        mRankMap.clear();
        mRankUsers.clear();
    }
}
