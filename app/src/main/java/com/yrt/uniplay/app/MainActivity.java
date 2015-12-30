package com.yrt.uniplay.app;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yrt.uniplay.app.activity.SettingActivity;
import com.yrt.uniplay.app.activity.ThemeActivity;
import com.yrt.uniplay.app.common.BaseActivity;
import com.yrt.uniplay.app.fragment.FragmentButton;
import com.yrt.uniplay.app.fragment.FragmentIndex;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;


@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements MaterialAccountListener {

    @ViewInject(R.id.toolbar)
    private Toolbar mToolbar;

    @Override
    protected void onResume() {
        super.onResume();
        initToolbar(mToolbar, getString(R.string.index), false);
    }

    @Override
    public void init(Bundle bundle) {
// add accounts
        MaterialAccount account = new MaterialAccount(this.getResources(), "NeoKree", "neokree@gmail.com", R.mipmap.ic_launcher, R.mipmap.sky);
        this.addAccount(account);

        // set listener
        this.setAccountListener(this);

        // create sections
        this.addSection(newSection("Section 1", new FragmentIndex()));
        this.addSection(newSection("Section 2", new FragmentIndex()));
        this.addSection(newSection("Section 3", R.mipmap.ic_action_accept, new FragmentButton()).setSectionColor(Color.parseColor("#9c27b0")));
        this.addSection(newSection("Section", R.mipmap.ic_action_accounts, new FragmentButton()).setSectionColor(Color.parseColor("#03a9f4")));

        // create bottom section
        this.addBottomSection(newSection("Bottom Section", R.mipmap.ic_action_person, new Intent(this, SettingActivity.class)));
    }

    @Event(value = R.id.btn1, type = View.OnClickListener.class)
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(ThemeActivity.class);
                break;
        }
    }

    @Override
    public void onAccountOpening(MaterialAccount materialAccount) {

    }

    @Override
    public void onChangeAccount(MaterialAccount materialAccount) {

    }
}
