package com.allever.java.project.quick.demo.base;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.allever.java.project.quick.databinding.DemoFragmentTabBinding;
import com.allever.java.project.quick.lib.viewpager.Pager2Adapter;
import com.allever.java.project.quick.lib.viewpager.ViewPagerUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class DemoTabFragment extends DemoBaseFragment<DemoFragmentTabBinding> {
    @Override
    public DemoFragmentTabBinding getViewBinding(ViewGroup container) {
        return DemoFragmentTabBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected void initView() {
        // 设置ViewPager的适配器
        mBinding.viewPager.setAdapter(new Pager2Adapter(this, getFragments()));

        // 调用扩展函数modifyTouchSlop
        ViewPagerUtils.modifyTouchSlop(mBinding.viewPager);

        // 将TabLayout与ViewPager2绑定，并设置标签标题
        mBinding.tabLayout.setViewPager2(mBinding.viewPager, getTabTitles());
    }

    @Override
    protected void initData() {

    }

    @NotNull
    public abstract ArrayList<String> getTabTitles();

    // 抽象方法，用于获取Fragment列表
    @NotNull
    public abstract List<Fragment> getFragments();

}
