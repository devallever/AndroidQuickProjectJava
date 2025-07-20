package com.allever.java.project.quick.demo;

import android.content.Intent;

import com.allever.java.project.quick.databinding.DemoActivityRippleBinding;
import com.allever.java.project.quick.lib.ui.widget.RippleHelper;

public class DemoRippleActivity extends DemoBaseActivity<DemoActivityRippleBinding>{
    @Override
    protected DemoActivityRippleBinding getViewBinding() {
        return DemoActivityRippleBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        RippleHelper.setOnClickListener(mBinding.btnRipple, () -> {
            startActivity(new Intent(this, DemoRippleActivity.class));
            finish();
        });
        RippleHelper.setOnClickListener(mBinding.ivRipple, () -> {
            startActivity(new Intent(this, DemoRippleActivity.class));
            finish();
        });

        RippleHelper.setOnClickListener(mBinding.btnRippleScreenWidth, () -> {
            startActivity(new Intent(this, DemoRippleActivity.class));
            finish();
        });
        RippleHelper.setOnClickListener(mBinding.btnRippleR8, () -> {
            startActivity(new Intent(this, DemoRippleActivity.class));
            finish();
        });
    }

    @Override
    protected void initData() {

    }
}
