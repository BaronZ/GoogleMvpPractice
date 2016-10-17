package com.zzb.googlemvppractice.di.component.app;

import com.zzb.googlemvppractice.di.module.github.GitHubApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/14.
 */
@Singleton
@Component(modules = GitHubApiModule.class)
public interface GitHubApiComponent {

}
