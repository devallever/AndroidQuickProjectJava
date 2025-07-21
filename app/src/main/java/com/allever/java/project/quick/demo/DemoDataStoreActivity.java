package com.allever.java.project.quick.demo;

import android.annotation.SuppressLint;

import com.allever.java.project.quick.databinding.DemoActivityDataStoreBinding;
import com.allever.java.project.quick.demo.base.DemoBaseActivity;
import com.allever.java.project.quick.demo.datastore.DemoConfig;

public class DemoDataStoreActivity extends DemoBaseActivity<DemoActivityDataStoreBinding> {
    @Override
    protected DemoActivityDataStoreBinding getViewBinding() {
        return DemoActivityDataStoreBinding.inflate(getLayoutInflater());
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        adaptStatusBar();
        mBinding.tvCounter.setText(DemoConfig.getCounter(0) + "");
        mBinding.btnCounter.setOnClickListener(v -> {
            DemoConfig.updateCounter(DemoConfig.getCounter(0) + 1);
            mBinding.tvCounter.setText(DemoConfig.getCounter(0) + "");
        });
    }

    @Override
    protected void initData() {

    }
}
