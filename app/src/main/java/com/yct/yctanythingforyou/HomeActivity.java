package com.yct.yctanythingforyou;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yct.yctanythingforyou.activity.base.BaseActivity;
import com.yct.yctanythingforyou.view.fragment.BaseFragment;
import com.yct.yctanythingforyou.view.fragment.home.HomeFragment;
import com.yct.yctanythingforyou.view.fragment.home.MessageFragment;
import com.yct.yctanythingforyou.view.fragment.home.MineFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private FragmentManager fm = null;

    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;

    private RelativeLayout content_layout;
    private TextView home_image_view;
    private TextView message_image_view;
    private TextView mine_image_view;

    private RelativeLayout home_layout_view;
    private RelativeLayout message_layout_view;
    private RelativeLayout mine_layout_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        initView();

        homeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, homeFragment);
        fragmentTransaction.commit();

    }

    private void initView() {
        content_layout = findViewById(R.id.content_layout);
        home_image_view = findViewById(R.id.home_image_view);
        home_image_view.setBackgroundResource(R.drawable.comui_tab_home_selected);
        message_image_view = findViewById(R.id.message_image_view);
        mine_image_view = findViewById(R.id.mine_image_view);

        home_layout_view = findViewById(R.id.home_layout_view);
        home_layout_view.setOnClickListener(this);
        message_layout_view = findViewById(R.id.message_layout_view);
        message_layout_view.setOnClickListener(this);
        mine_layout_view = findViewById(R.id.mine_layout_view);
        mine_layout_view.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.home_layout_view:
                home_image_view.setBackgroundResource(R.drawable.comui_tab_home_selected);
                message_image_view.setBackgroundResource(R.drawable.comui_tab_message);
                mine_image_view.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(messageFragment, fragmentTransaction);
                hideFragment(mineFragment, fragmentTransaction);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.message_layout_view:
                home_image_view.setBackgroundResource(R.drawable.comui_tab_home);
                message_image_view.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mine_image_view.setBackgroundResource(R.drawable.comui_tab_person);

                hideFragment(homeFragment, fragmentTransaction);
                hideFragment(mineFragment, fragmentTransaction);
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, messageFragment);
                } else {
                    fragmentTransaction.show(messageFragment);
                }
                break;
            case R.id.mine_layout_view:
                home_image_view.setBackgroundResource(R.drawable.comui_tab_home);
                message_image_view.setBackgroundResource(R.drawable.comui_tab_message);
                mine_image_view.setBackgroundResource(R.drawable.comui_tab_person_selected);

                hideFragment(messageFragment, fragmentTransaction);
                hideFragment(homeFragment, fragmentTransaction);
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mineFragment);
                } else {
                    fragmentTransaction.show(mineFragment);
                }

                break;
        }

        fragmentTransaction.commit();

    }

    private void hideFragment(BaseFragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }
}
