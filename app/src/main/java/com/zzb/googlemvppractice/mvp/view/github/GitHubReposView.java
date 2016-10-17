package com.zzb.googlemvppractice.mvp.view.github;

import com.zzb.googlemvppractice.entity.github.Repo;
import com.zzb.googlemvppractice.mvp.MvpView;

import java.util.List;

/**
 * Created by ZZB on 2016/10/14.
 */

public interface GitHubReposView extends MvpView {

    void showListReposLoading();

    void onListReposSuccess(List<Repo> repos);

    void onListReposFailed(String msg);

    void hideListReposLoading();

}
