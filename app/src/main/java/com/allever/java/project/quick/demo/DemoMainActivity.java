package com.allever.java.project.quick.demo;


import android.content.Intent;

import com.allever.java.project.quick.databinding.DemoMainActivityBinding;
import com.allever.java.project.quick.lib.ui.AbsBindingActivity;

public class DemoMainActivity extends AbsBindingActivity<DemoMainActivityBinding> {
    @Override
    protected DemoMainActivityBinding getViewBinding() {
        return DemoMainActivityBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        mBinding.btnStartSecond.setOnClickListener(v -> {
            //startActivity
            startActivity(new Intent(DemoMainActivity.this, SecondActivity.class));
        });
        mBinding.btnMvvm.setOnClickListener(v -> {
            //startActivity
            startActivity(new Intent(DemoMainActivity.this, DemoMvvmActivity.class));
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean isDarkMode() {
        return false;
    }
}
