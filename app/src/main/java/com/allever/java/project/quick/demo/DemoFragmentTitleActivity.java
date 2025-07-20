package com.allever.java.project.quick.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.allever.java.project.quick.databinding.DemoActivityFragmentTitleBinding;
import com.allever.java.project.quick.demo.adapter.DemoMenuActionAdapter;
import com.allever.java.project.quick.demo.adapter.item.DemoMenuItem;
import com.allever.java.project.quick.lib.ui.widget.RippleHelper;

import java.util.ArrayList;
import java.util.List;

public class DemoFragmentTitleActivity extends DemoBaseActivity<DemoActivityFragmentTitleBinding> {

    private DemoMenuActionAdapter mMenuActionAdapter;
    private final List<DemoMenuItem> mMenuActionList = new ArrayList<>();

    public static void start(Activity activity, Class<? extends Fragment> fragment, String title, Bundle fragmentBundle) {
        Intent intent = new Intent(activity, DemoFragmentTitleActivity.class);
        intent.putExtra("fragmentPkg", fragment.getName());
        intent.putExtra("fragmentBundle", fragmentBundle);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    @Override
    protected DemoActivityFragmentTitleBinding getViewBinding() {
        return DemoActivityFragmentTitleBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar(mBinding.topBar);
        String title = getIntent().getStringExtra("title");
        String fragmentPkg = getIntent().getStringExtra("fragmentPkg");
        Bundle bundle = getIntent().getBundleExtra("fragmentBundle");
        RippleHelper.setOnClickListener(mBinding.ivBack, () -> onBackPressed());
        mBinding.tvTitle.setText(title);
        Fragment fragment = null;
        try {
            fragment = (Fragment) Class.forName(fragmentPkg).getConstructor().newInstance();
            fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            addFragment(mBinding.fragmentContainer.getId(), fragment);
        }


        mMenuActionAdapter = new DemoMenuActionAdapter(mMenuActionList);
        mBinding.rvMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mBinding.rvMenu.setAdapter(mMenuActionAdapter);
        mMenuActionAdapter.setItemClickListener((data, position) -> {
            if (data.getAction() != null) {
                data.getAction().run();
            }
        });
    }

    @Override
    protected void initData() {

    }

}
