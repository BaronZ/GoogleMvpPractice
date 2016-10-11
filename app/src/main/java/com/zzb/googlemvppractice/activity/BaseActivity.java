package com.zzb.googlemvppractice.activity;

import android.support.v7.app.AppCompatActivity;

import com.zzb.googlemvppractice.MvpApplication;
import com.zzb.googlemvppractice.di.component.app.AppComponent;

/**
 * Created by ZZB on 2016/10/9.
 */

public class BaseActivity extends AppCompatActivity {

    public AppComponent getAppComponent(){
        return MvpApplication.getApplication().getAppComponent();
    }
}
