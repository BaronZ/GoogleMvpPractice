package com.zzb.googlemvppractice.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zzb.googlemvppractice.R;
import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract;
import com.zzb.googlemvppractice.contract.online_users.OnlineUsersContract.Presenter;
import com.zzb.googlemvppractice.entity.User;

import java.util.List;

/**
 * Created by ZZB on 2016/10/9.
 */

public class OnlineUsersView extends FrameLayout implements OnlineUsersContract.View {
    private TextView mTvContent;
    OnlineUsersContract.Presenter mOnlineUsersPresenter;

    public OnlineUsersView(Context context) {
        super(context);
        init(context);
    }

    public OnlineUsersView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OnlineUsersView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.online_users_view, this);
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }

//    public void init(OnlineUsersContract.Presenter onlineUsersPresenter) {
//        mOnlineUsersPresenter = onlineUsersPresenter;
//    }

    @Override
    public void updateOnlineUsers(List<User> onlineUsers) {
        StringBuilder sb = new StringBuilder();
        if (onlineUsers != null) {
            for (User user : onlineUsers) {
                sb.append(user.getUid()).append(":s ").append(user.getScore()).append("|");
            }
        }

        mTvContent.setText(sb.toString());
    }

    //=============presenter start
    public void onUserScoreChanged(User user) {
        mOnlineUsersPresenter.userScoreChanged(user);
    }

    public void joinRoom(User user) {
        mOnlineUsersPresenter.joinRoom(user);
    }

    public void leaveRoom(User user) {
        mOnlineUsersPresenter.leaveRoom(user);
    }

    public void selfLeaveRoom() {
        mOnlineUsersPresenter.selfLeaveRoom();
    }


    //============presenter end


    public void setOnlineUsersPresenter(Presenter onlineUsersPresenter) {
        mOnlineUsersPresenter = onlineUsersPresenter;
    }
}
