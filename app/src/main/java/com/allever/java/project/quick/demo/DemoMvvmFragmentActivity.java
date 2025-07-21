package com.allever.java.project.quick.demo;

import com.allever.java.project.quick.databinding.DemoActivityFragmentBinding;
import com.allever.java.project.quick.demo.base.DemoBaseActivity;
import com.allever.java.project.quick.demo.fragment.DemoMvvmFragment;

public class DemoMvvmFragmentActivity extends DemoBaseActivity<DemoActivityFragmentBinding> {
    @Override
    protected DemoActivityFragmentBinding getViewBinding() {
        return DemoActivityFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        addFragment(mBinding.fragmentContainer.getId(), new DemoMvvmFragment());
    }

    @Override
    protected void initData() {

    }
}
