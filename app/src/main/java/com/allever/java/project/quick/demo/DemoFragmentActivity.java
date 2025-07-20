package com.allever.java.project.quick.demo;

import com.allever.java.project.quick.DemoFragment;
import com.allever.java.project.quick.databinding.DemoActivityFragmentBinding;

public class DemoFragmentActivity extends DemoBaseActivity<DemoActivityFragmentBinding> {
    @Override
    protected DemoActivityFragmentBinding getViewBinding() {
        return DemoActivityFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        addFragment(mBinding.fragmentContainer.getId(), new DemoFragment());
    }

    @Override
    protected void initData() {

    }
}
