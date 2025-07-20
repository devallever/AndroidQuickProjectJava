package com.allever.java.project.quick.demo;


import android.content.Intent;

import com.allever.java.project.quick.databinding.DemoMainActivityBinding;

public class DemoMainActivity extends DemoBaseActivity<DemoMainActivityBinding> {
    @Override
    protected DemoMainActivityBinding getViewBinding() {
        return DemoMainActivityBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        mBinding.btnStartSecond.setOnClickListener(v -> {
            //startActivity
            startActivity(new Intent(DemoMainActivity.this, SecondActivity.class));
        });
        mBinding.btnMvvm.setOnClickListener(v -> {
            //startActivity
            startActivity(new Intent(DemoMainActivity.this, DemoMvvmActivity.class));
        });

        mBinding.btnNetwork.setOnClickListener(v -> {
            //startActivity
            startActivity(new Intent(DemoMainActivity.this, DemoNetworkActivity.class));
        });

        mBinding.btnDataStore.setOnClickListener(v -> {
            //startActivity
            startActivity(new Intent(DemoMainActivity.this, DemoDataStoreActivity.class));
        });

        mBinding.btnDatabase.setOnClickListener(v -> {
            //startActivity
            startActivity(new Intent(DemoMainActivity.this, DemoDatabaseActivity.class));
        });

        mBinding.btnPermission.setOnClickListener(v -> {
            startActivity(new Intent(DemoMainActivity.this, DemoPermissionActivity.class));
        });

        mBinding.btnRecyclerView.setOnClickListener(v -> {
            startActivity(new Intent(DemoMainActivity.this, DemoRecyclerViewActivity.class));
        });
    }

    @Override
    protected void initData() {

    }
}
