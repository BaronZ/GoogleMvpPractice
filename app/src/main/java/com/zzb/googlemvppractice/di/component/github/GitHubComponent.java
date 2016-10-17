package com.zzb.googlemvppractice.di.component.github;

import com.zzb.googlemvppractice.di.component.app.GitHubApiComponent;
import com.zzb.googlemvppractice.di.qualifier.PerActivity;

import dagger.Component;

/**
 * Created by ZZB on 2016/10/14.
 */
@PerActivity
@Component(dependencies = GitHubApiComponent.class)
public interface GitHubComponent {

}
