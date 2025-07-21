package com.allever.java.project.quick.demo;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.allever.java.project.quick.databinding.DemoActivityRecyclerViewBinding;
import com.allever.java.project.quick.demo.adapter.DemoItemAdapter;
import com.allever.java.project.quick.demo.adapter.item.DemoItem;
import com.allever.java.project.quick.demo.base.DemoBaseActivity;
import com.allever.java.project.quick.lib.util.GsonUtils;
import com.allever.java.project.quick.lib.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class DemoRecyclerViewActivity extends DemoBaseActivity<DemoActivityRecyclerViewBinding> {

    @Override
    protected void initView() {
        adaptStatusBar();
        List<DemoItem> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            DemoItem item = new DemoItem( "title" + i, "content" + i, null);
            data.add(item);
        }
        DemoItemAdapter adapter = new DemoItemAdapter(data);
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rv.setAdapter(adapter);
        adapter.setItemClickListener((item, position) -> {
            ToastUtils.show(GsonUtils.toJson(item));
        });
    }

    @Override
    protected DemoActivityRecyclerViewBinding getViewBinding() {
        return DemoActivityRecyclerViewBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {

    }
}
