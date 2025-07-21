package com.allever.java.project.quick.demo;

import android.annotation.SuppressLint;

import com.allever.java.project.quick.R;
import com.allever.java.project.quick.databinding.DemoActivityMyTitleBinding;
import com.allever.java.project.quick.demo.adapter.item.DemoMenuItem;
import com.allever.java.project.quick.lib.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class DemoMyTitleActivity extends DemoBaseTitleActivity<DemoActivityMyTitleBinding> {
    @Override
    protected DemoActivityMyTitleBinding getContentViewBinding() {
        return DemoActivityMyTitleBinding.inflate(getLayoutInflater());
    }

    @Override
    protected List<DemoMenuItem> getMenuActionList() {
        return new ArrayList<>() {
            {
                add(new DemoMenuItem(R.drawable.demo_ic_menu_power, () -> {
                    ToastUtils.show("power");
                }));
                add(new DemoMenuItem(R.drawable.demo_ic_menu_printer, () -> {
                    ToastUtils.show("Printer");
                }));
                add(new DemoMenuItem(R.drawable.demo_ic_menu_setting, () -> {
                    ToastUtils.show("Setting");
                }));
            }
        };
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initTopBar() {
//        initTopBar(this.getClass().getSimpleName(), false,  true, true, true);
//        initBackTitleBar(this.getClass().getSimpleName());
//        initCenterTitleBar(this.getClass().getSimpleName());
        initBackMenuTitleBar(this.getClass().getSimpleName());
//        disableTopBar();
//        adaptStatusBar(mContentBinding.tvContent);
    }
}
