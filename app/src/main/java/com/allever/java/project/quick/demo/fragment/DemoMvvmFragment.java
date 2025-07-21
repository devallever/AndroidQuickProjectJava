package com.allever.java.project.quick.demo.fragment;

import android.view.ViewGroup;

import com.allever.java.project.quick.databinding.DemoFragmentMvvmBinding;
import com.allever.java.project.quick.demo.DemoViewModel;
import com.allever.java.project.quick.lib.mvvm.AbsMvvmFragment;

public class DemoMvvmFragment extends AbsMvvmFragment<DemoFragmentMvvmBinding, DemoViewModel> {
    @Override
    public void initObserver() {
        mViewModel.counterLiveData.observe(this, s -> {
            mBinding.tvCounter.setText(s);
        });
    }

    @Override
    public DemoFragmentMvvmBinding getViewBinding(ViewGroup container) {
        return DemoFragmentMvvmBinding.inflate(getLayoutInflater(), container, false);
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
}
