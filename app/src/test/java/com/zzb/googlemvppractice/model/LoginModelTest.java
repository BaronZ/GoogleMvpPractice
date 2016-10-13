package com.zzb.googlemvppractice.model;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.login.LoginModel;
import com.zzb.googlemvppractice.model.user.UserModel;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import rx.observers.TestSubscriber;

/**
 * Created by ZZB on 2016/10/13.
 */

public class LoginModelTest {
    LoginModel mLoginModel;
    @Before
    public void setUp(){
        mLoginModel = new LoginModel(new UserModel());
    }

    @Test
    public void rx_onNext_test(){
        TestSubscriber<User> testSubscriber = new TestSubscriber<>();
        String phone = "1";
        User expectedUser = new User(phone.hashCode());
        expectedUser.setNick(phone);

        mLoginModel.phoneLogin(phone, "1").subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Arrays.asList(expectedUser));
        testSubscriber.assertCompleted();

    }
    @Test
    public void rx_onError_test(){
        TestSubscriber<User> testSubscriber = new TestSubscriber<>();
        String phone = "1";
        mLoginModel.phoneLogin(phone, "2").subscribe(testSubscriber);
        testSubscriber.assertError(RuntimeException.class);
        testSubscriber.assertNotCompleted();

    }
}
