package com.yrt.uniplay.app.presenter;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.presenter
 * Author Mengjiaxin
 * Date 2015/12/21 19:44
 * Desc 登录的Presenter
 */
public interface ILoginPresenter {

    /**
     * 校验用户名密码
     *
     * @param username 用户名
     * @param password 密码
     */
    void validateCredentials(String username, String password);
}
