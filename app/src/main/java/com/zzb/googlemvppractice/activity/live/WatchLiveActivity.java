package com.zzb.googlemvppractice.activity.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zzb.googlemvppractice.R;
import com.zzb.googlemvppractice.activity.BaseActivity;
import com.zzb.googlemvppractice.contract.live.WatchLiveContact;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.live.LiveModel;
import com.zzb.googlemvppractice.model.live.WatchLivePushController;
import com.zzb.googlemvppractice.model.online_users.OnlineUsersModel;
import com.zzb.googlemvppractice.presenter.live.WatchLivePresenter;
import com.zzb.googlemvppractice.widget.OnlineUsersView;

public class WatchLiveActivity extends BaseActivity implements View.OnClickListener, WatchLiveContact.View {
    private OnlineUsersView mOnlineUsersView;
    private WatchLivePushController mWatchLivePushController;
    private OnlineUsersModel mOnlineUsersModel;
    private LiveModel mLiveModel;
    private WatchLivePresenter mWatchLivePresenter;

    public static void launch(Context context) {
        Intent intent = new Intent(context, WatchLiveActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_live);
        initModels();
        initPresenters();
        initViews();
        initPushController();
    }

    private void initPresenters() {
        mWatchLivePresenter = new WatchLivePresenter(mLiveModel, this);
    }

    private void initModels() {
        mLiveModel = new LiveModel();
        mOnlineUsersModel = new OnlineUsersModel(mLiveModel);
    }

    private void initViews() {
        mOnlineUsersView = (OnlineUsersView) findViewById(R.id.online_users_view);
        mOnlineUsersView.init(mOnlineUsersModel, mLiveModel);

    }

    private void initPushController() {
        mWatchLivePushController = new WatchLivePushController();
        mWatchLivePushController.setOnlineUsersPresenter(mOnlineUsersView.getOnlineUsersPresenter());
        mWatchLivePushController.setWatchLivePresenter(mWatchLivePresenter);
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
