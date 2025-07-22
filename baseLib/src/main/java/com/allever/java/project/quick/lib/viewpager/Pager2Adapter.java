package com.allever.java.project.quick.lib.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

/**
 * @author allever
 */
public class Pager2Adapter extends FragmentStateAdapter {

    protected List<Fragment> mFragmentList;

    public Pager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);
        this.mFragmentList = fragmentList;
    }

    public Pager2Adapter(@NonNull Fragment fragment, List<Fragment> fragmentList) {
        super(fragment);
        this.mFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragmentList != null ? mFragmentList.size() : 0;
    }
}
