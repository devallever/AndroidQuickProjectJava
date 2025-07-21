package com.allever.java.project.quick.demo.base;

import android.os.Bundle;
import android.view.Gravity;
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
        initTopBar();
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

    abstract protected void initTopBar();

    protected void initBackTitleBar(String title) {
        initTopBar(title, false, true, false, true);
    }

    protected void initCenterTitleBar(String title) {
        initTopBar(title, true, false, false, true);
    }

    protected void disableTopBar() {
        initTopBar("", false, false, false, false);
    }

    protected void initBackMenuTitleBar(String title) {
        initTopBar(title, false, true, true, true);
    }

    protected void initTopBar(String title, boolean isCenter, boolean enableBack, boolean enableMenu, boolean enableTopBar){
        mBinding.tvTitle.setText(title);
        if (isCenter) {
            mBinding.tvTitle.setGravity(Gravity.CENTER);
        } else {
            mBinding.tvTitle.setGravity(Gravity.START);
        }
        if (enableBack) {
            mBinding.ivBack.setVisibility(View.VISIBLE);
        } else {
            mBinding.ivBack.setVisibility(View.GONE);
        }
        if (enableMenu) {
            mBinding.rvMenu.setVisibility(View.VISIBLE);
        } else {
            mBinding.rvMenu.setVisibility(View.GONE);
        }
        if (enableTopBar) {
            mBinding.topBarContainer.setVisibility(View.VISIBLE);
        } else {
            mBinding.topBarContainer.setVisibility(View.GONE);
        }
    }

    protected boolean enableBackAction() {
        return true;
    }

    protected boolean enableMenu() {
        return true;
    }

    protected boolean enableTopBar() {
        return true;
    }

    protected int titleGravity() {
        return Gravity.START;
    }

}
