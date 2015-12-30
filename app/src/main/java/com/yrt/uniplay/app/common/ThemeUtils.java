package com.yrt.uniplay.app.common;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;

import com.afollestad.materialdialogs.ThemeSingleton;
import com.afollestad.materialdialogs.util.DialogUtils;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.common
 * Author Mengjiaxin
 * Date 2015/12/30 12:09
 * Desc 主题工具类
 */
public class ThemeUtils {


    public static void setSystemToolbarColor(BaseActivity activity, int color) {
        activity.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
        ThemeSingleton.get().positiveColor = DialogUtils.getActionTextStateList(activity, color);
        ThemeSingleton.get().neutralColor = DialogUtils.getActionTextStateList(activity, color);
        ThemeSingleton.get().negativeColor = DialogUtils.getActionTextStateList(activity, color);
        ThemeSingleton.get().widgetColor = color;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(shiftColor(color));
            activity.getWindow().setNavigationBarColor(color);
        }
    }

    private static int shiftColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.9f; // value component
        return Color.HSVToColor(hsv);
    }
}
