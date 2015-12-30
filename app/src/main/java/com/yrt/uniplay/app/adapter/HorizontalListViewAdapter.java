package com.yrt.uniplay.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.ThemeSingleton;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.amulyakhare.textdrawable.TextDrawable;
import com.yrt.uniplay.app.R;

/**
 * 用于改变主题中的横屏color显示
 */
public class HorizontalListViewAdapter extends BaseAdapter {
    private int[] mIconIDs;
    private String[] mTitles;
    private Context mContext;
    private LayoutInflater mInflater;

    // 选中的位置
    private int selectedPosition = 0;

    public HorizontalListViewAdapter(Context context, String[] titles, int[] ids) {
        this.mContext = context;
        this.mIconIDs = ids;
        this.mTitles = titles;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mIconIDs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item_theme, null);
            holder.mImage = (ImageView) convertView.findViewById(R.id.list_item_theme_iv);
            holder.mTitle = (TextView) convertView.findViewById(R.id.list_item_theme_tv);
            holder.mSelected = (ImageView) convertView.findViewById(R.id.list_item_theme_selected_iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTitle.setText(mTitles[position]);
        // 设置圆角
        TextDrawable drawable = TextDrawable.builder().buildRoundRect("", mIconIDs[position], 12);
        holder.mImage.setImageDrawable(drawable);

        if (selectedPosition == position)
            holder.mSelected.setVisibility(View.VISIBLE);
        else
            holder.mSelected.setVisibility(View.GONE);

        return convertView;
    }

    private static class ViewHolder {
        private TextView mTitle;
        private ImageView mImage;
        private ImageView mSelected;
    }

}