package com.yrt.uniplay.app.common.Image;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.yrt.uniplay.app.R;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.common.Image
 * Author Mengjiaxin
 * Date 2015/12/22 17:04
 * Desc 加载的图片信息配置
 */
public class DisplayImageOptionSetting {

    public static DisplayImageOptions options;

    public static DisplayImageOptions optionsCacheInDisc() {
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_menu_gallery) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_menu_report_image) //设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_menu_report_image) //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(false) //设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) //设置下载的图片是否缓存在SD卡中
                .considerExifParams(true) //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT) //设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565) //设置图片的解码类型//
                        //.decodingOptions(android.graphics.BitmapFactory.Options decodingOptions) //设置图片的解码配置
                .delayBeforeLoading(0) //int delayInMillis为你设置的下载前的延迟时间
                .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
                .build();//构建完成

        return options;
    }
}
