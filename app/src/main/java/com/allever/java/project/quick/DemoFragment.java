package com.allever.java.project.quick;

import android.view.ViewGroup;

import com.allever.java.project.quick.databinding.DemoFragmentBinding;
import com.allever.java.project.quick.lib.ui.AbsBindingFragment;

public class DemoFragment extends AbsBindingFragment<DemoFragmentBinding> {
    @Override
    public DemoFragmentBinding getViewBinding(ViewGroup container) {
        return DemoFragmentBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
