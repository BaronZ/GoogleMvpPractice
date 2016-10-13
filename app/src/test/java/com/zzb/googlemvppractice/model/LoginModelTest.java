package com.zzb.googlemvppractice.model;

import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.login.LoginModel;
import com.zzb.googlemvppractice.model.user.UserModel;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ZZB on 2016/10/13.
 */

public class LoginModelTest {
    LoginModel mLoginModel;
    TestSubscriber<User> mUserTestSubscriber;
    @Before
    public void setUp(){
        mLoginModel = new LoginModel(new UserModel());
        mUserTestSubscriber = new TestSubscriber<>();
    }

    @Test
    public void rx_onNext_test(){
        String phone = "1";
        User expectedUser = new User(phone.hashCode());
        expectedUser.setNick(phone);

        mLoginModel.phoneLogin(phone, "1").toBlocking().subscribe(mUserTestSubscriber);
        mUserTestSubscriber.assertNoErrors();
        mUserTestSubscriber.assertReceivedOnNext(Collections.singletonList(expectedUser));
        mUserTestSubscriber.assertCompleted();

    }
    @Test
    public void rx_getOnNextEvent_test(){
        String phone = "1";
        User expectedUser = new User(phone.hashCode());
        expectedUser.setNick(phone);

        mLoginModel.phoneLogin(phone, "1").toBlocking().subscribe(mUserTestSubscriber);
        mUserTestSubscriber.assertNoErrors();
        mUserTestSubscriber.assertCompleted();
//        mUserTestSubscriber.assertReceivedOnNext(Collections.singletonList(expectedUser));
        List<User> users = mUserTestSubscriber.getOnNextEvents();
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(phone, users.get(0).getNick());
    }
    @Test
    public void rx_onError_test(){
        String phone = "1";
        mLoginModel.phoneLogin(phone, "2").toBlocking().subscribe(mUserTestSubscriber);
        mUserTestSubscriber.assertError(RuntimeException.class);
        mUserTestSubscriber.assertNotCompleted();

    }
}
