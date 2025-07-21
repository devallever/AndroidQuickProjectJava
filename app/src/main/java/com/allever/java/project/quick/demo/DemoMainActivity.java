package com.allever.java.project.quick.demo;


import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.allever.java.project.quick.databinding.DemoMainActivityBinding;

import java.util.ArrayList;
import java.util.List;

public class DemoMainActivity extends DemoBaseActivity<DemoMainActivityBinding> {
    private final List<DemoItem> mData = new ArrayList<>();

    @Override
    protected DemoMainActivityBinding getViewBinding() {
        return DemoMainActivityBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        mData.add(new DemoItem("测试滑动删除", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, SecondActivity.class));
        }));
        mData.add(new DemoItem("MVVM", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoMvvmActivity.class));
        }));
        mData.add(new DemoItem("网络", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoNetworkActivity.class));
        }));
        mData.add(new DemoItem("DataStore", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoDataStoreActivity.class));
        }));
        mData.add(new DemoItem("数据库", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoDatabaseActivity.class));
        }));
        mData.add(new DemoItem("权限", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoPermissionActivity.class));
        }));
        mData.add(new DemoItem("RecyclerView", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoRecyclerViewActivity.class));
        }));
        mData.add(new DemoItem("Fragment", "", () -> {
            Bundle bundle = new Bundle();
            bundle.putString("userName", "Allever");
            DemoFragmentActivity.start(DemoMainActivity.this, DemoContentFragment.class, bundle);
        }));
        mData.add(new DemoItem("Mvvm Fragment", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoMvvmFragmentActivity.class));
        }));
        mData.add(new DemoItem("Ripple", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoRippleActivity.class));
        }));
        mData.add(new DemoItem("BaseTitleActivity", "", () -> {
            startActivity(new Intent(DemoMainActivity.this, DemoMyTitleActivity.class));
        }));
        mData.add(new DemoItem("TitleFragmentActivity", "", () -> {
            Bundle bundle = new Bundle();
            bundle.putString("userName", "Allever");
            DemoFragmentTitleActivity.start(DemoMainActivity.this, DemoContentFragment.class, "TitleFragmentActivity", bundle);
        }));
        mData.add(new DemoItem("ImageLoader", "", () -> {
            DemoFragmentTitleActivity.start(DemoMainActivity.this, DemoImageLoaderFragment.class, "ImageLoader", null);
        }));

        //adapter
        DemoItemAdapter adapter = new DemoItemAdapter(mData);
        mBinding.rvFunc.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvFunc.setAdapter(adapter);
        adapter.setItemClickListener((item, position) -> {
            if (item.getAction() != null) {
                item.getAction().run();
            }
        });
    }

    @Override
    protected void initData() {

    }


}
