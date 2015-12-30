package com.yrt.uniplay.app.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import org.xutils.x;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.common
 * Author Mengjiaxin
 * Date 2015/12/21 16:45
 * Desc 基本的Activity
 */
public abstract class BaseActivity extends MaterialNavigationDrawer {

    /**
     * Activity的状态
     */
    private static final int ACTIVITY_RESUME = 0;
    private static final int ACTIVITY_STOP = 1;
    private static final int ACTIVITY_PAUSE = 2;
    private static final int ACTIVITY_DESTROY = 3;

    // Activity的当前状态
    public int activityState;

    private YrtApplication mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加AppManager中
        AppManager.getAppManager().addActivity(this);
        // 注入view, 这里注入后继承BaseActivity就可以不用再次注入了.
        x.view().inject(this);
        mApplication = (YrtApplication) x.app();

    }

    /**
     * 初始化Toolbar
     *
     * @param toolbar
     * @param title
     * @param isBack
     */
    protected void initToolbar(Toolbar toolbar, String title, boolean isBack) {
        setSupportActionBar(toolbar);
        setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(isBack);
        int colorPosition = SharedPrefsUtil.getValue(this, SharedPrefsUtil.COLOR, 0);
        if (colorPosition == 0) {
            initSystemBar(this, mApplication.getColors()[0], toolbar);
            ThemeUtils.setSystemToolbarColor(this, mApplication.getColors()[0]);
        } else {
            initSystemBar(this, mApplication.getColors()[colorPosition], toolbar);
            ThemeUtils.setSystemToolbarColor(this, mApplication.getColors()[colorPosition]);
        }
    }

    public YrtApplication getYrtApplication() {
        return mApplication;
    }

    @TargetApi(19)
    private static void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);

    }

    public void initSystemBar(Activity activity, int color, Toolbar toolbar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);

        tintManager.setNavigationBarTintEnabled(true);
        // 使用颜色资源
        tintManager.setStatusBarTintColor(color);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, getStatusBarHeight(), 0, 0);
        toolbar.setLayoutParams(lp);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 向指定的handler中发送消息
     *
     * @param handler
     * @param what
     */
    public void sendMessage(Handler handler, int what) {
        Message message = new Message();
        message.what = what;
        handler.sendMessage(message);
    }

    /**
     * 向指定的handler中发送带数据的消息
     *
     * @param handler
     * @param data
     * @param what
     */
    public void sendMessage(Handler handler, Bundle data, int what) {
        Message message = new Message();
        message.what = what;
        message.setData(data);
        handler.sendMessage(message);
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public boolean isNotEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return false;
        else
            return true;
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return
     */
    public boolean isNotEmpty(Object object) {
        if (object == null)
            return false;
        else
            return true;
    }

    /**
     * 启动Activity
     *
     * @param pClass
     */
    protected void startActivity(Class<?> pClass) {
        startActivity(pClass, null);
    }

    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param pClass
     * @param pBundle
     */
    protected void startActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    /**
     * Activity创建或者从后台重新回到前台时被调用
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Activity从后台重新回到前台时被调用
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * Activity创建或者从被覆盖、后台重新回到前台时被调用
     */
    @Override
    protected void onResume() {
        super.onResume();
        activityState = ACTIVITY_RESUME;
    }

    /**
     * 退出当前Activity或者跳转到新Activity时被调用
     */
    @Override
    protected void onStop() {
        super.onStop();
        activityState = ACTIVITY_STOP;
    }

    /**
     * Activity被覆盖到下面或者锁屏时被调用
     */
    @Override
    protected void onPause() {
        super.onPause();
        activityState = ACTIVITY_PAUSE;
    }

    /**
     * 退出当前Activity时被调用,调用之后Activity就结束了
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityState = ACTIVITY_DESTROY;
    }
}
