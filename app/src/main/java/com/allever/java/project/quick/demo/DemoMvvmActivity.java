package com.allever.java.project.quick.demo;


import com.allever.java.project.quick.databinding.DemoActivityMvvmBinding;
import com.allever.java.project.quick.lib.mvvm.AbsMvvmActivity;

public class DemoMvvmActivity extends AbsMvvmActivity<DemoActivityMvvmBinding, DemoViewModel> {
    @Override
    public void initObserver() {
        mViewModel.counterLiveData.observe(this, s -> {
            mBinding.tvCounter.setText(s);
        });
    }

    @Override
    protected DemoActivityMvvmBinding getViewBinding() {
        return DemoActivityMvvmBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        mBinding.btnCounter.setOnClickListener(v -> {
            mViewModel.updateCounter();
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
