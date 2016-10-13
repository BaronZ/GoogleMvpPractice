package com.zzb.googlemvppractice.presenter;

import com.zzb.googlemvppractice.contract.login.PhoneLoginContract;
import com.zzb.googlemvppractice.entity.User;
import com.zzb.googlemvppractice.model.login.LoginModel;
import com.zzb.googlemvppractice.model.user.UserModel;
import com.zzb.googlemvppractice.presenter.login.PhoneLoginPresenter;
import com.zzb.googlemvppractice.util.schedulers.BaseSchedulerProvider;
import com.zzb.googlemvppractice.util.schedulers.ImmediateSchedulerProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by ZZB on 2016/10/12.
 */

public class LoginPresenterTest {
    @Mock
    PhoneLoginContract.View mPhoneLoginView;
    private PhoneLoginPresenter mPhoneLoginPresenter;
    private BaseSchedulerProvider mBaseSchedulerProvider;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mBaseSchedulerProvider = new ImmediateSchedulerProvider();LoginModel loginModel = new LoginModel(new UserModel());
        mPhoneLoginPresenter = new PhoneLoginPresenter(mPhoneLoginView, loginModel, mBaseSchedulerProvider);
    }
    @Test
    public void login_success_test() {
        //登录,这是一个登录成功的流程
        mPhoneLoginPresenter.login("1", "1");

        //执行了上面的login方法之后期望调用View中的下面三个方法，如果按顺序执行，测试通过
        verify(mPhoneLoginView).showLoginDialog();//显示Loading
        verify(mPhoneLoginView).showLoginSuccess(any(User.class));//登录成功回调
        verify(mPhoneLoginView).hideLoginDialog();//隐藏Loading
    }
    @Test
    public void login_failed_test() {
        //登录,这是一个登录失败的流程
        mPhoneLoginPresenter.login("", "");

        //执行了上面的login方法之后期望调用View中的下面三个方法，如果按顺序执行，测试通过
        verify(mPhoneLoginView).showLoginDialog();//显示Loading
        verify(mPhoneLoginView).showLoginError(anyString());//登录失败回调
        verify(mPhoneLoginView).hideLoginDialog();//隐藏Loading

    }
}
