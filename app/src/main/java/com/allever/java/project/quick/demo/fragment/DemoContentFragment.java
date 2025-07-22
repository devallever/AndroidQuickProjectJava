package com.allever.java.project.quick.demo.fragment;

import android.os.Bundle;
import android.view.ViewGroup;

import com.allever.java.project.quick.databinding.DemoFragmentContentBinding;
import com.allever.java.project.quick.demo.base.DemoBaseFragment;

public class DemoContentFragment extends DemoBaseFragment<DemoFragmentContentBinding> {


    public static DemoContentFragment newInstance(String content) {
        DemoContentFragment fragment = new DemoContentFragment();
        Bundle args = new Bundle();
        args.putString("content", content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public DemoFragmentContentBinding getViewBinding(ViewGroup container) {
        return DemoFragmentContentBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String userName = bundle.getString("content");
            mBinding.tvContent.setText(userName);
        }
    }

    @Override
    protected void initData() {

    }
}
