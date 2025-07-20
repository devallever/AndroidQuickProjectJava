package com.allever.java.project.quick.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allever.java.project.quick.databinding.DemoItemRvBinding;
import com.allever.java.project.quick.lib.ui.recyclerview.AbsAdapter;

import java.util.List;

public class DemoItemAdapter extends AbsAdapter<DemoItem, DemoItemRvBinding> {
    public DemoItemAdapter(List<DemoItem> data) {
        super(data);
    }

    @Override
    public DemoItemRvBinding getBinding(ViewGroup parent) {
        return DemoItemRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public void onBindingViewHolder(DemoItem item, DemoItemRvBinding binding, int position) {
        binding.tvTitle.setText(item.getTitle());
        if (item.getContent().isEmpty()) {
            binding.tvDesc.setVisibility(View.GONE);
        } else {
            binding.tvDesc.setVisibility(View.VISIBLE);
        }
        binding.tvDesc.setText(item.getContent());
    }
}
