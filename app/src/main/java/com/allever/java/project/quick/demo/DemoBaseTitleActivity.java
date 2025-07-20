package com.allever.java.project.quick.demo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.allever.java.project.quick.databinding.DemoActivityBaseTitleBinding;
import com.allever.java.project.quick.demo.adapter.DemoMenuActionAdapter;
import com.allever.java.project.quick.demo.adapter.item.DemoMenuItem;
import com.allever.java.project.quick.lib.ui.widget.RippleHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class DemoBaseTitleActivity<CVB extends ViewBinding> extends DemoBaseActivity<DemoActivityBaseTitleBinding> {

    protected CVB mContentBinding;
    private DemoMenuActionAdapter mMenuActionAdapter;
    private final List<DemoMenuItem> mMenuActionList = new ArrayList<>();

    @Override
    protected DemoActivityBaseTitleBinding getViewBinding() {
        return DemoActivityBaseTitleBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mContentBinding = getContentViewBinding();
        super.onCreate(savedInstanceState);
        adaptStatusBar(mBinding.topBar);
        RippleHelper.setOnClickListener(mBinding.ivBack, () -> onBackPressed());
        mBinding.contentView.addView(mContentBinding.getRoot());
        mMenuActionList.addAll(getMenuActionList());
        mMenuActionAdapter = new DemoMenuActionAdapter(mMenuActionList);
        mBinding.rvMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mBinding.rvMenu.setAdapter(mMenuActionAdapter);
        mMenuActionAdapter.setItemClickListener((data, position) -> {
            if (data.getAction() != null) {
                data.getAction().run();
            }
        });
    }

    abstract protected CVB getContentViewBinding();

    abstract protected List<DemoMenuItem> getMenuActionList();
}
