package com.allever.java.project.quick.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.allever.java.project.quick.databinding.DemoActivityFragmentBinding;

public class DemoFragmentActivity extends DemoBaseActivity<DemoActivityFragmentBinding> {

    public static void start(Activity activity, Class<? extends Fragment> fragment, Bundle fragmentBundle) {
        Intent intent = new Intent(activity, DemoFragmentActivity.class);
        intent.putExtra("fragmentPkg", fragment.getName());
        intent.putExtra("fragmentBundle", fragmentBundle);
        activity.startActivity(intent);
    }
    @Override
    protected DemoActivityFragmentBinding getViewBinding() {
        return DemoActivityFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        String fragmentPkg = getIntent().getStringExtra("fragmentPkg");
        Bundle fragmentBundle = getIntent().getBundleExtra("fragmentBundle");
        Fragment fragment = null;
        try {
            fragment = (Fragment) Class.forName(fragmentPkg).getConstructor().newInstance();
            fragment.setArguments(fragmentBundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            addFragment(mBinding.fragmentContainer.getId(), fragment);
        }
    }

    @Override
    protected void initData() {

    }
}
