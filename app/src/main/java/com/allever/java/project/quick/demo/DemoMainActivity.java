package com.allever.java.project.quick.demo;

import com.allever.java.project.quick.R;
import com.allever.java.project.quick.databinding.DemoMainActivityBinding;
import com.allever.java.project.quick.demo.base.DemoBaseActivity;
import com.allever.java.project.quick.demo.base.DemoFragmentTitleActivity;
import com.allever.java.project.quick.demo.fragment.DemoContentFragment;

public class DemoMainActivity extends DemoBaseActivity<DemoMainActivityBinding> {

    @Override
    protected DemoMainActivityBinding getViewBinding() {
        return DemoMainActivityBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        DemoFragmentTitleActivity.start(this, DemoMainFragment.class, getString(R.string.app_name), null);
        finish();
    }

    @Override
    protected void initData() {

    }


}
