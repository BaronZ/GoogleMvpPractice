package com.zzb.googlemvppractice.mvp.presenter.github;

import com.zzb.googlemvppractice.entity.github.Repo;
import com.zzb.googlemvppractice.mvp.BasePresenter;
import com.zzb.googlemvppractice.mvp.api.GitHubApi;
import com.zzb.googlemvppractice.mvp.view.github.GitHubReposView;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by ZZB on 2016/10/14.
 */

public class GitHubPresenter extends BasePresenter<GitHubReposView> {

    GitHubReposView mGitHubReposView;
    GitHubApi mGitHubApi;

    public GitHubPresenter(GitHubReposView gitHubReposView, GitHubApi gitHubApi) {
        mGitHubReposView = gitHubReposView;
        mGitHubApi = gitHubApi;
    }

    public void listUserRepos(String user) {
        mGitHubReposView.showListReposLoading();
        mGitHubApi.listRepos(user).subscribe(new Action1<List<Repo>>() {
            @Override
            public void call(List<Repo> repos) {
                getMvpView().hideListReposLoading();
                getMvpView().onListReposSuccess(repos);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getMvpView().hideListReposLoading();
                getMvpView().onListReposFailed(throwable.getMessage());
            }
        });
    }
}
