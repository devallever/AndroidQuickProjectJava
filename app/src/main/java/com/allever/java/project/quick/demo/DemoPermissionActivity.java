package com.allever.java.project.quick.demo;


import android.Manifest;

import androidx.annotation.NonNull;

import com.allever.java.project.quick.databinding.DemoActivityPermissionBinding;
import com.allever.java.project.quick.lib.permission.PermissionUtils;
import com.allever.java.project.quick.lib.util.ToastUtils;

public class DemoPermissionActivity extends DemoBaseActivity<DemoActivityPermissionBinding> {
    @Override
    protected DemoActivityPermissionBinding getViewBinding() {
        return DemoActivityPermissionBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        mBinding.btnPermission.setOnClickListener(v -> {
            PermissionUtils.requestPermission(this, Manifest.permission.CAMERA);
        });

        mBinding.btnStoreMedia.setOnClickListener(v -> {
            PermissionUtils.requestMediaStorePermission(this, () -> {
                ToastUtils.show("已授权");
            });
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.handlePermissionResult(this, permissions, requestCode, () -> {
            ToastUtils.show("hasPermission");
        });
    }
}
