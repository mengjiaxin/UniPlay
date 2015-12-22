package com.yrt.uniplay.app.interactor;

import android.os.Handler;
import android.text.TextUtils;

import com.yrt.uniplay.app.listener.OnLoginFinishedListener;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.interactor.impl
 * Author Mengjiaxin
 * Date 2015/12/21 19:53
 * Desc 请用一句话来描述作用
 */
public class LoginInteractorImpl implements ILoginInteractor {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        });
    }
}
