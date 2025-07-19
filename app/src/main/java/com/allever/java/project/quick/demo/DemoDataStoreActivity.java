package com.allever.java.project.quick.demo;

import android.annotation.SuppressLint;

import com.allever.java.project.quick.databinding.DemoActivityDataStoreBinding;
import com.allever.java.project.quick.demo.datastore.DemoConfig;
import com.allever.java.project.quick.lib.ui.AbsBindingActivity;

public class DemoDataStoreActivity extends AbsBindingActivity<DemoActivityDataStoreBinding> {
    @Override
    protected DemoActivityDataStoreBinding getViewBinding() {
        return DemoActivityDataStoreBinding.inflate(getLayoutInflater());
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
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
