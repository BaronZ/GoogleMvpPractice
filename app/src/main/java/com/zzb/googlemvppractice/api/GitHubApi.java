package com.zzb.googlemvppractice.api;

import com.zzb.googlemvppractice.entity.github.Repo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ZZB on 2016/10/14.
 */

public interface GitHubApi {

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);
}
