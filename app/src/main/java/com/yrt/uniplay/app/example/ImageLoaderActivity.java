package com.yrt.uniplay.app.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.yrt.uniplay.app.R;
import com.yrt.uniplay.app.adapter.CommonAdapter;
import com.yrt.uniplay.app.adapter.ViewHolder;
import com.yrt.uniplay.app.common.BaseActivity;
import com.yrt.uniplay.app.common.Image.DisplayImageOptionSetting;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.util.LocalDisplay;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.example
 * Author Mengjiaxin
 * Date 2015/12/21 15:51
 * Desc 使用universal-image-loader和xutils分别来加载图片
 */
@ContentView(R.layout.example_image_loader)
public class ImageLoaderActivity extends BaseActivity {

    private String[] urls = {
            "http://www.bz55.com/uploads/allimg/150309/139-150309101A0.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101A1.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101A3.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101A7.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101A8.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101F2.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101F3.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101F7.jpg",
            "http://www.bz55.com/uploads/allimg/150309/139-150309101F8.jpg",
            "http://pic38.nipic.com/20140215/12359647_223607521106_2.jpg",
            "http://pic33.nipic.com/20130912/7327524_154404261138_2.jpg",
            "http://pic44.nipic.com/20140721/9491615_111800297000_2.jpg",
            "http://img.article.pchome.net/00/35/62/34/pic_lib/wm/Zhiwu36.jpg",
            "http://file01.16sucai.com/d/file/2013-11-10/13840690015078.jpg",
            "http://pic33.nipic.com/20130921/13661616_134254255181_2.jpg",
            "http://pic.58pic.com/10/42/90/96bOOOPICc9.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1209/10/c1/13758581_1347257278695.jpg",
            "http://www.deskcar.com/desktop/fengjing/2011722123730/18.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1209/10/c1/13758581_1347257278707.jpg",
            "http://www.6188.com/upload_6188s/flashAll/s800/20110419/1303204742G7qwqe.jpg",
            "http://www.lightingchina.com/focus/syds/picture/20093291733550.jpg",
            "http://tupian.enterdesk.com/2012/1102/gha/5/enterdeskcom%20%2811%29.jpg",
            "http://img.taopic.com/uploads/allimg/110719/1859-110G9193G763.jpg",
            "http://i2.tietuku.com/cfe7af7521f13a3d.jpg",
            "http://pic22.nipic.com/20120710/3375652_150953577107_2.jpg",
            "http://img.taopic.com/uploads/allimg/120502/128211-120502101F356.jpg",
            "http://img3.fengniao.com/travel/2_960/1673.jpg",
            "http://file02.16sucai.com/d/file/2014/0513/ae6ecae0974f3f975e6cec1013d4e6bb.jpg",
            "http://pic48.nipic.com/file/20140901/12398452_222239764000_2.jpg",
            "http://www.bz55.com/uploads/allimg/150316/139-150316113H5.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1212/06/c1/16396010_1354784049722.jpg",
            "http://pic4.nipic.com/20090722/1114225_134939075_2.jpg"
    };

    @ViewInject(R.id.rotate_header_grid_view)
    private GridView mGridView;

    @Override
    public void init() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < urls.length; i++)
            list.add(urls[i]);

        mGridView.setAdapter(new CommonAdapter<String>(this, list, R.layout.with_grid_view_item_image_list_grid) {
            @Override
            public void convert(ViewHolder helper, String item) {
                final ImageView imageView = helper.getView(R.id.with_grid_view_item_image);
                ImageSize targetSize = new ImageSize(LocalDisplay.dp2px(96), LocalDisplay.dp2px(96));
                ImageLoader.getInstance().loadImage(item, targetSize, DisplayImageOptionSetting.optionsCacheInDisc(), new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        imageView.setImageBitmap(loadedImage);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImageLoader.getInstance().clearDiskCache();
        ImageLoader.getInstance().clearMemoryCache();
    }
}

