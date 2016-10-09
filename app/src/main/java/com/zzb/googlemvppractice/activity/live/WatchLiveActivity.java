package com.zzb.googlemvppractice.activity.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zzb.googlemvppractice.R;
import com.zzb.googlemvppractice.activity.BaseActivity;
import com.zzb.googlemvppractice.model.live.WatchLivePushController;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;
import com.zzb.googlemvppractice.widget.OnlineUsersView;

public class WatchLiveActivity extends BaseActivity implements View.OnClickListener {
    private OnlineUsersView mOnlineUsersView;
    private WatchLivePushController mWatchLivePushController;

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
        mWatchLivePushController = new WatchLivePushController();
        mWatchLivePushController.setOnlineUsersView(mOnlineUsersView);
    }

    private void onLeaveLiveRoom() {
        mOnlineUsersView.selfLeaveRoom();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                mWatchLivePushController.onReceivePushMessage("1");
                break;
            case R.id.btn_remove:
                mWatchLivePushController.onReceivePushMessage("2");
                break;
            case R.id.btn_leave:
                onLeaveLiveRoom();
                break;
        }
    }
}
