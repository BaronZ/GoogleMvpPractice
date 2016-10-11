package com.zzb.googlemvppractice.activity.login;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.zzb.googlemvppractice.R;
import com.zzb.googlemvppractice.activity.BaseActivity;
import com.zzb.googlemvppractice.activity.live.WatchLiveActivity;
import com.zzb.googlemvppractice.contract.login.PhoneLoginContract;
import com.zzb.googlemvppractice.di.component.login.DaggerLoginComponent;
import com.zzb.googlemvppractice.di.module.login.LoginModule;
import com.zzb.googlemvppractice.entity.User;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements PhoneLoginContract.View {

    @Inject
    PhoneLoginContract.Presenter mPhonePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initDI();
        View btnLogin = findViewById(R.id.btn_login);
        final EditText etPhone = (EditText) findViewById(R.id.et_phone);
        final EditText etPsw = (EditText) findViewById(R.id.et_psw);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhonePresenter.login(getEtText(etPhone), getEtText(etPsw));
            }
        });
    }

    private void initDI() {
        DaggerLoginComponent.builder()
                .appComponent(getAppComponent())
                .loginModule(new LoginModule(this))
                .build().inject(this);
    }

    @Override
    public void showLoginDialog() {
        Toast.makeText(this, "login...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess(User user) {
        Toast.makeText(this, "login success, welcome " + user.getNick(), Toast.LENGTH_SHORT).show();
        WatchLiveActivity.launch(this);
    }

    @Override
    public void showLoginError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void hideLoginDialog() {
        Toast.makeText(this, "hide dialog", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isActive() {
        // fragment isAdded();
    }


    private String getEtText(EditText et) {
        Editable editable = et.getText();
        return editable == null ? "" : editable.toString();
    }
}
