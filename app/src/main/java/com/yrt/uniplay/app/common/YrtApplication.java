package com.yrt.uniplay.app.common;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.yrt.uniplay.app.R;

import org.xutils.DbManager;
import org.xutils.config.DbConfigs;
import org.xutils.x;

import java.io.File;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.common
 * Author Mengjiaxin
 * Date 2015/12/21 16:35
 * Desc 全局的application
 */
public class YrtApplication extends Application {

    // 颜色的值
    private int[] mColors;
    // 颜色的名字
    private String[] mColorNames;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化xUtils3
        // 这里初始化完成后整个项目就可以使用
        // x.http():
        //      1、x.http().get() 2、x.http().post() 3、x.http().request()
        // x.image(): 图片加载
        // x.getDb(): 使用数据库
        x.Ext.init(this);
        // 设置debug模式
        x.Ext.setDebug(Constant.DEBUG);
        // 初始化主题颜色
        initColors();

        // 初始化本地数据库
//        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig();
//        // 设置数据库名称
//        daoConfig.setDbName(Constant.DB_NAME);
//        x.getDb(daoConfig);

        // 初始化图片加载
        initImageLoader(getApplicationContext());
    }

    /**
     * 初始化图片加载配置
     *
     * @param context
     */
    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

    /**
     * 初始化颜色数组
     */
    private void initColors() {
        // 初始化颜色的值
        final TypedArray colorTa = getResources().obtainTypedArray(R.array.colors);
        mColors = new int[colorTa.length()];
        for (int i = 0; i < colorTa.length(); i++)
            mColors[i] = colorTa.getColor(i, 0);
        // 回收TypedArray，以便后面重用。在调用这个函数后，你就不能再使用这个TypedArray。
        colorTa.recycle();

        // 初始化颜色的名称
        final TypedArray colorNameTa = getResources().obtainTypedArray(R.array.colors_name);
        mColorNames = new String[colorNameTa.length()];
        for (int i = 0; i < colorNameTa.length(); i++)
            mColorNames[i] = colorNameTa.getString(i);
        colorNameTa.recycle();
    }

    public int[] getColors() {
        return mColors;
    }

    public String[] getColorNames() {
        return mColorNames;
    }
}
