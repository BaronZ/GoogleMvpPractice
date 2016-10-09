package com.zzb.googlemvppractice.activity.login;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.zzb.googlemvppractice.Injection;
import com.zzb.googlemvppractice.R;
import com.zzb.googlemvppractice.activity.BaseActivity;
import com.zzb.googlemvppractice.contract.login.PhoneLoginContract;
import com.zzb.googlemvppractice.presenter.login.PhoneLoginPresenter;

public class LoginActivity extends BaseActivity implements PhoneLoginContract.View {

    private PhoneLoginContract.Presenter mPhonePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View btnLogin = findViewById(R.id.btn_login);
        final EditText etPhone = (EditText) findViewById(R.id.et_phone);
        final EditText etPsw = (EditText) findViewById(R.id.et_psw);
        new PhoneLoginPresenter(Injection.provideLoginModel(), this);//// TODO: 2016/9/30 why do we need setPresenter, why not directly instance presenter
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhonePresenter.login(getEtText(etPhone), getEtText(etPsw));
            }
        });
    }

    @Override
    public void showLoginDialog() {
        Toast.makeText(this, "login...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoginDialog() {
        Toast.makeText(this, "hide dialog", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isActive() {
        // fragment isAdded();
    }

    @Override
    public void setPresenter(PhoneLoginContract.Presenter presenter) {
        mPhonePresenter = presenter;
    }

    private String getEtText(EditText et){
        Editable editable = et.getText();
        return editable == null ? "" : editable.toString();
    }
}
