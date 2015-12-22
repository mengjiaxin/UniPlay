package com.yrt.uniplay.app.listener;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.listener
 * Author Mengjiaxin
 * Date 2015/12/21 19:49
 * Desc 登录执行完成后的回调
 */
public interface OnLoginFinishedListener {

    /**
     * 用户名有误
     */
    void onUsernameError();

    /**
     * 密码有误
     */
    void onPasswordError();

    /**
     * 执行成功
     */
    void onSuccess();
}
