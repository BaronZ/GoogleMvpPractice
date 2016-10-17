package com.zzb.googlemvppractice;

import com.zzb.googlemvppractice.di.component.app.DaggerGitHubApiComponent;
import com.zzb.googlemvppractice.di.component.app.GitHubApiComponent;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ZZB on 2016/10/14.
 */

public class DaggerScopeTest {


    @Test
    public void singleton(){
        GitHubApiComponent c1 = DaggerGitHubApiComponent.builder().build();
        GitHubApiComponent c2 = DaggerGitHubApiComponent.builder().build();
        //@singleton 不是正在意义上的单例
        Assert.assertNotEquals(c1, c2);

    }
}
