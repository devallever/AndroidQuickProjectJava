package com.allever.java.project.quick.demo;

import com.allever.java.project.quick.databinding.DemoActivitySecondBinding;
import com.allever.java.project.quick.lib.ui.AbsBindingActivity;

public class SecondActivity extends AbsBindingActivity<DemoActivitySecondBinding> {

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected DemoActivitySecondBinding getViewBinding() {
        return DemoActivitySecondBinding.inflate(getLayoutInflater());
    }


    @Override
    protected boolean isDarkMode() {
        return false;
    }
}
