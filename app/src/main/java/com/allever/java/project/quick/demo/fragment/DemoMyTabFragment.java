package com.allever.java.project.quick.demo.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class DemoMyTabFragment extends DemoTabFragment{
    @NonNull
    @Override
    public ArrayList<String> getTabTitles() {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Tab1");
        titles.add("Tab2");
        titles.add("Tab3");
        titles.add("Tab4");
        titles.add("Tab5");
        titles.add("Tab6");
        titles.add("Tab7");
        return titles;
    }

    @NonNull
    @Override
    public List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(DemoContentFragment.newInstance("Tab1"));
        fragments.add(DemoContentFragment.newInstance("Tab2"));
        fragments.add(DemoContentFragment.newInstance("Tab3"));
        fragments.add(DemoContentFragment.newInstance("Tab4"));
        fragments.add(DemoContentFragment.newInstance("Tab5"));
        fragments.add(DemoContentFragment.newInstance("Tab6"));
        fragments.add(DemoContentFragment.newInstance("Tab7"));
        return fragments;
    }
}
