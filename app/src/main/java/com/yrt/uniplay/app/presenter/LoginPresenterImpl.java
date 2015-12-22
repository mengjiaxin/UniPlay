package com.yrt.uniplay.app.presenter;

import com.yrt.uniplay.app.interactor.ILoginInteractor;
import com.yrt.uniplay.app.interactor.LoginInteractorImpl;
import com.yrt.uniplay.app.listener.OnLoginFinishedListener;
import com.yrt.uniplay.app.view.LoginView;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.presenter.impl
 * Author Mengjiaxin
 * Date 2015/12/21 19:46
 * Desc 登录的Presenter实现
 */
public class LoginPresenterImpl implements ILoginPresenter, OnLoginFinishedListener {

    private LoginView mLoginView;
    private ILoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        mLoginView.showProgress();
        mLoginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError() {
        mLoginView.setUsernameError();
        mLoginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        mLoginView.setPasswordError();
        mLoginView.hideProgress();
    }

    @Override
    public void onSuccess() {
        mLoginView.navigateToHome();
    }
}
