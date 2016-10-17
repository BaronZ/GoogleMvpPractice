package com.zzb.googlemvppractice.mvp;

/**
 * Created by ZZB on 2016/10/14.
 */

public class BasePresenter<V extends MvpView> implements Presenter<V> {
    private V mMvpView;
    private boolean mIsAttachViewMethodCalled = false;

    @Override
    public void attachView(V mvpView) {
        mIsAttachViewMethodCalled = true;
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    @Override
    public V getMvpView() {
        if (!mIsAttachViewMethodCalled) {
            throw new RuntimeException("please call attachView first");
        }
        return mMvpView;
    }
}
