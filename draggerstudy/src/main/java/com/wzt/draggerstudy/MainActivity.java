package com.wzt.draggerstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wzt.draggerstudy.login.ILoginPresenter;
import com.wzt.draggerstudy.login.LoginPresenterImpl;
import com.wzt.draggerstudy.view.DaggerMainComponent;
import com.wzt.draggerstudy.view.ILoginView;
import com.wzt.draggerstudy.view.ViewModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private TextView mTextView;
    @Inject
    LoginPresenterImpl mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
//        mLogin = new LoginPresenterImpl(this);
        DaggerMainComponent.builder()
                .viewModule(new ViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onLoginResult(int code, String msg) {
        mTextView.setText(msg);
    }

    @Override
    public void onClear() {
        mTextView.setText("");
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.button:
                mLogin.login("wang");
                break;
            case R.id.button2:
                mLogin.clear();
                break;
            default:
                break;
        }
    }
}
