package com.allever.java.project.quick.demo.base;

import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allever.java.project.quick.databinding.DemoFragmentListBinding;
import com.allever.java.project.quick.lib.ui.recyclerview.AbsAdapter;
import com.allever.java.project.quick.lib.ui.recyclerview.ItemClickListener;
import com.allever.java.project.quick.lib.util.GsonUtils;
import com.allever.java.project.quick.lib.util.ToastUtils;

import java.util.List;

public abstract class DemoListFragment<D> extends DemoBaseFragment<DemoFragmentListBinding> {
    protected AbsAdapter<D, ?> mAdapter;

    @Override
    public DemoFragmentListBinding getViewBinding(ViewGroup container) {
        return DemoFragmentListBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected void initView() {
        mAdapter = getAdapter();
        mAdapter.setData(getDataList());
        mBinding.recyclerView.setLayoutManager(getLayoutManager());
        mBinding.recyclerView.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new ItemClickListener<D>() {
            @Override
            public void onItemClick(D data, int position) {
                onItemClicked(data, position);
            }
        });
    }

    @Override
    protected void initData() {

    }

    protected abstract AbsAdapter<D, ?> getAdapter();

    protected abstract List<D> getDataList();

    protected void onItemClicked(D item, int position) {
        ToastUtils.show(GsonUtils.toJson(item));
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(requireContext());
    }

}
