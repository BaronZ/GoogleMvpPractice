package com.zzb.googlemvppractice.activity.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.zzb.googlemvppractice.R;
import com.zzb.googlemvppractice.activity.BaseActivity;
import com.zzb.googlemvppractice.model.live.WatchLivePushController;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;
import com.zzb.googlemvppractice.widget.OnlineUsersView;

public class WatchLiveActivity extends BaseActivity {
    private OnlineUsersView mOnlineUsersView;


    public static void launch(Context context) {
        Intent intent = new Intent(context, WatchLiveActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_live);

        initViews();
        initPushController();
    }

    private void initViews() {
        mOnlineUsersView = (OnlineUsersView) findViewById(R.id.online_users_view);
        mOnlineUsersView.init(new OnlineUsersModel());

    }

    private void initPushController() {
        WatchLivePushController watchLivePushController = new WatchLivePushController();
        watchLivePushController.setOnlineUsersView(mOnlineUsersView);
    }

    private void onLeaveLiveRoom() {
        mOnlineUsersView.selfLeaveRoom();
    }


}
