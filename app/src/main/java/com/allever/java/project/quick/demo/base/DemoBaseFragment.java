package com.allever.java.project.quick.demo.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.allever.java.project.quick.lib.statusbar.StatusBarCompat;
import com.allever.java.project.quick.lib.ui.AbsBindingFragment;
import com.allever.java.project.quick.lib.util.LogUtils;

public abstract class DemoBaseFragment<VB extends ViewBinding> extends AbsBindingFragment<VB> {

    protected void adaptStatusBar() {
        mBinding.getRoot().post(() -> {
            View firstView = ((ViewGroup)mBinding.getRoot()).getChildAt(0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) firstView.getLayoutParams();
            int statusBarHeight = StatusBarCompat.getStatusBarHeight(requireContext());
            LogUtils.d("statusBarHeight: " + statusBarHeight);
            marginLayoutParams.topMargin = statusBarHeight;
            firstView.setLayoutParams(marginLayoutParams);
        });
    }

    protected void adaptStatusBar(View target) {
        View TargetView = target;
        if (target == null) {
            TargetView = ((ViewGroup)mBinding.getRoot()).getChildAt(0);
        }
        final View finalTargetView = TargetView;
        mBinding.getRoot().post(() -> {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) finalTargetView.getLayoutParams();
            int statusBarHeight = StatusBarCompat.getStatusBarHeight(requireContext());
            LogUtils.d("statusBarHeight: " + statusBarHeight);
            marginLayoutParams.topMargin = statusBarHeight;
            finalTargetView.setLayoutParams(marginLayoutParams);
        });
    }
}
