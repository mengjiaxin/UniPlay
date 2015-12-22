package com.yrt.uniplay.app.view;

import java.util.List;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.mvp.view
 * Author Mengjiaxin
 * Date 2015/12/22 9:06
 * Desc 请用一句话来描述作用
 */
public interface JsonView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);

}