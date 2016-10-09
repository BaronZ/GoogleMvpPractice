package com.zzb.googlemvppractice;

import com.zzb.googlemvppractice.model.login.ILoginModel;
import com.zzb.googlemvppractice.model.login.LoginModelImpl;

/**
 * Created by ZZB on 2016/9/30.
 */

public class Injection {

    public static ILoginModel provideLoginModel(){
        return new LoginModelImpl();
    }
}
