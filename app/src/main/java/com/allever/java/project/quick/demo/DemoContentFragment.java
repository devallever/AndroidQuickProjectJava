package com.allever.java.project.quick.demo;

import android.os.Bundle;
import android.view.ViewGroup;

import com.allever.java.project.quick.databinding.DemoFragmentContentBinding;

public class DemoContentFragment extends DemoBaseFragment<DemoFragmentContentBinding> {
    @Override
    public DemoFragmentContentBinding getViewBinding(ViewGroup container) {
        return DemoFragmentContentBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String userName = bundle.getString("userName");
            mBinding.tvContent.setText(userName);

        }
    }

    @Override
    protected void initData() {

    }
}
