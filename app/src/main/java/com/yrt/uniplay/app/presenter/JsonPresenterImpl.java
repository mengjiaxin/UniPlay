package com.yrt.uniplay.app.presenter;

import com.yrt.uniplay.app.interactor.IJsonInteractor;
import com.yrt.uniplay.app.interactor.JsonInteractorImpl;
import com.yrt.uniplay.app.listener.OnJsonFinshedListener;
import com.yrt.uniplay.app.view.JsonView;

import java.util.List;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.mvp.presenter
 * Author Mengjiaxin
 * Date 2015/12/22 9:09
 * Desc 请用一句话来描述作用
 */
public class JsonPresenterImpl implements IJsonPresenter, OnJsonFinshedListener {

    private JsonView mJsonView;
    private IJsonInteractor mJsonInteractor;

    public JsonPresenterImpl(JsonView jsonView) {
        this.mJsonView = jsonView;
        mJsonInteractor = new JsonInteractorImpl();
    }

    @Override
    public void onResume() {
        mJsonView.showProgress();
        mJsonInteractor.findItems(this);
    }

    @Override
    public void onItemClickd(int position) {
        mJsonView.showMessage("position:  " + position + 1);
    }

    @Override
    public void onFinshed(List<String> items) {
        mJsonView.hideProgress();
        mJsonView.setItems(items);
    }
}
