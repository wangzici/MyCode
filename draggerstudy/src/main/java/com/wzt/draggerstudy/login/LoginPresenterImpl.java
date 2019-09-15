package com.wzt.draggerstudy.login;

import android.os.Handler;
import android.os.Looper;

import com.wzt.draggerstudy.view.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter {
    private ILoginView mLoginView;
    private Handler mUiHandler = new Handler(Looper.getMainLooper());

    public LoginPresenterImpl(ILoginView loginView) {
        mLoginView = loginView;
    }

    @Override
    public void login(String userName) {
        mLoginView.onLoginResult(1, "login start with userName = " + userName);
        mUiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.onLoginResult(0, "login success");
            }
        }, 5000);
    }

    @Override
    public void clear() {
        mLoginView.onClear();
    }
}
