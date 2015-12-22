package com.yrt.uniplay.app.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.yrt.uniplay.app.R;
import com.yrt.uniplay.app.common.AppManager;
import com.yrt.uniplay.app.common.BaseActivity;
import com.yrt.uniplay.app.example.JSONActivity;
import com.yrt.uniplay.app.presenter.ILoginPresenter;
import com.yrt.uniplay.app.presenter.LoginPresenterImpl;
import com.yrt.uniplay.app.view.LoginView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.activity
 * Author Mengjiaxin
 * Date 2015/12/21 19:58
 * Desc 登录界面
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    @ViewInject(R.id.progress)
    private ProgressBar mProgressBar;
    @ViewInject(R.id.username)
    private EditText mUsernameTextView;
    @ViewInject(R.id.password)
    private EditText mPasswordTextView;
    @ViewInject(R.id.button)
    private Button mButton;

    private ILoginPresenter mPresenter;

    @Override
    public void init() {
        mPresenter = new LoginPresenterImpl(this);
        mButton.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        mUsernameTextView.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        mPasswordTextView.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(JSONActivity.class);

        AppManager.getAppManager().finishActivity(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mPresenter.validateCredentials(mUsernameTextView.getText().toString(), mPasswordTextView.getText().toString());
                break;
        }
    }
}
