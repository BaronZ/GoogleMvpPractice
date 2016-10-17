package com.zzb.googlemvppractice.di.module.github;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by ZZB on 2016/10/14.
 */
@Module
public class GitHubApiModule {

    @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient httpClient = new OkHttpClient();
        return httpClient;
    }
}
