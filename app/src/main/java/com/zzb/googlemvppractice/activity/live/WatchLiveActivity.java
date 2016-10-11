package com.zzb.googlemvppractice.activity.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zzb.googlemvppractice.R;
import com.zzb.googlemvppractice.activity.BaseActivity;
import com.zzb.googlemvppractice.contract.live.WatchLiveContact;
import com.zzb.googlemvppractice.di.live.DaggerWatchLiveComponent;
import com.zzb.googlemvppractice.di.live.OnlineUsersModule;
import com.zzb.googlemvppractice.di.live.WatchLiveModule;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.live.WatchLivePushController;
import com.zzb.googlemvppractice.widget.OnlineUsersView;

import javax.inject.Inject;

public class WatchLiveActivity extends BaseActivity implements View.OnClickListener, WatchLiveContact.View {
    private OnlineUsersView mOnlineUsersView;
    @Inject
    WatchLivePushController mWatchLivePushController;
    @Inject
    WatchLiveContact.Presenter mWatchLivePresenter;

    public static void launch(Context context) {
        Intent intent = new Intent(context, WatchLiveActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_live);
        initViews();
        initInjections();
    }

    private void initInjections() {
        DaggerWatchLiveComponent.builder()
                .watchLiveModule(new WatchLiveModule(this))
                .onlineUsersModule(new OnlineUsersModule(mOnlineUsersView))
                .build().inject(this);
    }


    private void initViews() {
        mOnlineUsersView = (OnlineUsersView) findViewById(R.id.online_users_view);

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
            case R.id.btn_update_rank:
                mWatchLivePushController.onReceivePushMessage("3");
                break;
            case R.id.btn_leave:
                onLeaveLiveRoom();
                break;
        }
    }

    @Override
    public void onGetLiveShowDataSuccess() {

    }

    @Override
    public void onGetLiveShowDataFailed() {

    }

    @Override
    public void onRankChanged(User user) {
        mOnlineUsersView.onUserScoreChanged(user);
    }
}
