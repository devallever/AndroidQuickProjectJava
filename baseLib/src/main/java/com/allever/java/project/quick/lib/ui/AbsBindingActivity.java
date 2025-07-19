package com.allever.java.project.quick.lib.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

public abstract class AbsBindingActivity<VB extends ViewBinding> extends AbsActivity{
    protected VB mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mBinding = getViewBinding();
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());
    }

    protected abstract VB getViewBinding();

}
