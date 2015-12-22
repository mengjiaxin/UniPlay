package com.yrt.uniplay.app.interactor;

import com.yrt.uniplay.app.listener.OnLoginFinishedListener;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.interactor
 * Author Mengjiaxin
 * Date 2015/12/21 19:52
 * Desc 请用一句话来描述作用
 */
public interface ILoginInteractor {

    void login(String username, String password, OnLoginFinishedListener listener);

}
