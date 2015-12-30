package com.yrt.uniplay.app.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.yrt.uniplay.app.R;
import com.yrt.uniplay.app.adapter.HorizontalListViewAdapter;
import com.yrt.uniplay.app.common.AppManager;
import com.yrt.uniplay.app.common.BaseActivity;
import com.yrt.uniplay.app.common.SharedPrefsUtil;
import com.yrt.uniplay.app.common.ThemeUtils;
import com.yrt.uniplay.app.common.view.HorizontalListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.activity
 * Author Mengjiaxin
 * Date 2015/12/28 13:02
 * Desc 设置主题
 */
@ContentView(R.layout.activity_theme)
public class ThemeActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @ViewInject(R.id.theme_iv)
    private ImageView mImageView;
    @ViewInject(R.id.theme_hlv)
    private HorizontalListView mListView;
    @ViewInject(R.id.toolbar)
    private Toolbar mToolbar;

    private HorizontalListViewAdapter mAdapter;

    @Override
    public void init(Bundle bundle) {
        initListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initToolbar(mToolbar, getString(R.string.setting_theme_color), true);
    }

    /**
     * 初始化listview
     */
    private void initListView() {
        // 获取颜色的下标
        int colorPosition = SharedPrefsUtil.getValue(this, SharedPrefsUtil.COLOR, 0);
        mAdapter = new HorizontalListViewAdapter(this, getYrtApplication().getColorNames(), getYrtApplication().getColors());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        // 设置勾选的默认值
        mAdapter.setSelectedPosition(colorPosition);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 设置勾选
        mAdapter.setSelectedPosition(position);
        mAdapter.notifyDataSetChanged();
        // 将选择的颜色位置存下来
        SharedPrefsUtil.putValue(this, SharedPrefsUtil.COLOR, position);
        // 设置toolbar颜色
        ThemeUtils.setSystemToolbarColor(this, getYrtApplication().getColors()[position]);
        // 设置状态栏颜色
        initSystemBar(this, getYrtApplication().getColors()[position], mToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 点击返回按钮
        if (item.getItemId() == android.R.id.home) {
            AppManager.getAppManager().finishActivity(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
