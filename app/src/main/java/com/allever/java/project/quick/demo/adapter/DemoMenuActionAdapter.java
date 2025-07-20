package com.allever.java.project.quick.demo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.allever.java.project.quick.databinding.DemoItemActionMenuBinding;
import com.allever.java.project.quick.demo.adapter.item.DemoMenuItem;
import com.allever.java.project.quick.lib.ui.recyclerview.AbsAdapter;

import java.util.List;

public class DemoMenuActionAdapter extends AbsAdapter<DemoMenuItem, DemoItemActionMenuBinding> {
    public DemoMenuActionAdapter(List<DemoMenuItem> data) {
        super(data);
    }

    @Override
    public DemoItemActionMenuBinding getBinding(ViewGroup parent) {
        return DemoItemActionMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public void onBindingViewHolder(DemoMenuItem item, DemoItemActionMenuBinding binding, int position) {
        binding.ivIcon.setImageResource(item.getIconResId());
    }
}
