package com.yrt.uniplay.app.example;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.yrt.uniplay.app.R;
import com.yrt.uniplay.app.common.BaseActivity;
import com.yrt.uniplay.app.common.ToastUtils;
import com.yrt.uniplay.app.presenter.IJsonPresenter;
import com.yrt.uniplay.app.presenter.JsonPresenterImpl;
import com.yrt.uniplay.app.view.JsonView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.example
 * Author Mengjiaxin
 * Date 2015/12/21 16:22
 * Desc 请用一句话来描述作用
 */

@ContentView(R.layout.example_json)
public class JSONActivity extends BaseActivity implements JsonView, AdapterView.OnItemClickListener {

    @ViewInject(R.id.list)
    private ListView mListView;
    @ViewInject(R.id.progress)
    private ProgressBar mProgressBar;

    private IJsonPresenter mJsonPresenter;


    @Override
    protected void onResume() {
        super.onResume();
        mJsonPresenter.onResume();
    }

    @Override
    public void init(Bundle bundle) {
        mJsonPresenter = new JsonPresenterImpl(this);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showShort(this, message);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mJsonPresenter.onItemClickd(position);
    }
}