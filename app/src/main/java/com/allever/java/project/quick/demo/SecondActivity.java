package com.allever.java.project.quick.demo;

import com.allever.java.project.quick.databinding.DemoActivitySecondBinding;

public class SecondActivity extends DemoBaseActivity<DemoActivitySecondBinding> {

    @Override
    protected void initView() {
        adaptStatusBar();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected DemoActivitySecondBinding getViewBinding() {
        return DemoActivitySecondBinding.inflate(getLayoutInflater());
    }

}
