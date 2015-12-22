package com.yrt.uniplay.app.interactor;

import com.yrt.uniplay.app.listener.OnJsonFinshedListener;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.mvp.interactor
 * Author Mengjiaxin
 * Date 2015/12/22 9:12
 * Desc 请用一句话来描述作用
 */
public interface IJsonInteractor {

    void findItems(OnJsonFinshedListener listener);

}
