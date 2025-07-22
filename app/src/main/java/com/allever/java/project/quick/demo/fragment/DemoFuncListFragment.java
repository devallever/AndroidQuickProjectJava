package com.allever.java.project.quick.demo.fragment;

import com.allever.java.project.quick.demo.adapter.DemoItemAdapter;
import com.allever.java.project.quick.demo.adapter.item.DemoItem;
import com.allever.java.project.quick.demo.base.DemoListFragment;
import com.allever.java.project.quick.lib.ui.recyclerview.AbsAdapter;
import com.allever.java.project.quick.lib.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class DemoFuncListFragment extends DemoListFragment<DemoItem> {
    @Override
    protected AbsAdapter<DemoItem, ?> getAdapter() {
        return new DemoItemAdapter(new ArrayList<>());
    }

    @Override
    protected List<DemoItem> getDataList() {
        List<DemoItem> list = mAdapter.getData();
        list.clear();
        String func = "Func";
        for (int i = 1; i<= 20; i++) {
            list.add(new DemoItem(func + i, "", () -> {
                ToastUtils.show("handle action");
            }));
        }
        return list;
    }

    @Override
    protected void onItemClicked(DemoItem item, int position) {
        if (item.getAction() != null) {
            item.getAction().run();
        }
    }
}
