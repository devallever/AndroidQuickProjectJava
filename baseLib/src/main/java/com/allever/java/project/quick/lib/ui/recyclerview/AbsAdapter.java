package com.allever.java.project.quick.lib.ui.recyclerview;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.allever.java.project.quick.lib.ui.widget.RippleHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsAdapter<D, VB extends ViewBinding> extends RecyclerView.Adapter<AbsViewHolder<VB>> {

    private final List<D> data;

    private ItemClickListener<D> itemClickListener;

    private ItemLongClickListener<D> itemLongClickListener;

    public AbsAdapter(List<D> data) {
        this.data = data;
    }

    public void setData(List<D> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    public void setItemClickListener(ItemClickListener<D> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setItemLongClickListener(ItemLongClickListener<D> itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    @NonNull
    @Override
    public AbsViewHolder<VB> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AbsViewHolder<>(getBinding(parent));
    }

    @Override
    public void onBindViewHolder(@NonNull AbsViewHolder<VB> holder, int position) {
        D item = data.get(position);
        VB binding = holder.getBinding();
        if (itemClickListener != null) {
            RippleHelper.setOnClickListener(binding.getRoot(), () -> itemClickListener.onItemClick(item, position));
        }
        if (itemLongClickListener != null) {
            binding.getRoot().setOnLongClickListener(v -> itemLongClickListener.onItemLongClick(item, position));
        }
        onBindingViewHolder(item, binding, position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public abstract VB getBinding(ViewGroup parent);

    public abstract void onBindingViewHolder(D item, VB binding, int position);

    public List<D> getData() {
        return new ArrayList<>(data);
    }
}
