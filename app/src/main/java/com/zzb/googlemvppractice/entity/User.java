package com.zzb.googlemvppractice.entity;

/**
 * Created by ZZB on 2016/10/9.
 */

public class User {
    private long uid;
    private String nick;
    private String avatar;
    private int score;

    public User(long uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return uid == user.uid;

    }

    @Override
    public int hashCode() {
        return (int) (uid ^ (uid >>> 32));
    }
}
