package com.yrt.uniplay.app.view;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.mvp.view
 * Author Mengjiaxin
 * Date 2015/12/21 19:57
 * Desc 请用一句话来描述作用
 */
public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

}
