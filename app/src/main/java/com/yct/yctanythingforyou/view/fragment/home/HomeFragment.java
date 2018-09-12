package com.yct.yctanythingforyou.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yct.yctanythingforyou.R;
import com.yct.yctanythingforyou.view.fragment.BaseFragment;

public class HomeFragment extends BaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_layout, container, false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
