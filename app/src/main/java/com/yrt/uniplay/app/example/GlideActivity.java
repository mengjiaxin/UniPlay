package com.yrt.uniplay.app.example;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yrt.uniplay.app.R;
import com.yrt.uniplay.app.common.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.example
 * Author Mengjiaxin
 * Date 2015/12/25 17:24
 * Desc 测试视频播放
 */

@ContentView(R.layout.example_glide)
public class GlideActivity extends BaseActivity {

    @ViewInject(R.id.glide)
    private ImageView mGlideImageView;


    @Override
    public void init(Bundle bundle) {
        String flvUrl = "http://www.yrt9527.com/upload/league/video/201512/23202144mkxt.flv";

        Glide.with(this).load(flvUrl).into(mGlideImageView);
    }
}
