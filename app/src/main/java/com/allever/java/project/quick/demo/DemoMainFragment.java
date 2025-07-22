package com.allever.java.project.quick.demo;


import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.allever.java.project.quick.databinding.DemoMainFragmentBinding;
import com.allever.java.project.quick.demo.adapter.DemoItemAdapter;
import com.allever.java.project.quick.demo.adapter.item.DemoItem;
import com.allever.java.project.quick.demo.base.DemoBaseFragment;
import com.allever.java.project.quick.demo.base.DemoFragmentTitleActivity;
import com.allever.java.project.quick.demo.fragment.DemoContentFragment;
import com.allever.java.project.quick.demo.fragment.DemoMyTabFragment;
import com.allever.java.project.quick.demo.fragment.DemoTabFragment;

import java.util.ArrayList;
import java.util.List;

public class DemoMainFragment extends DemoBaseFragment<DemoMainFragmentBinding> {
    private final List<DemoItem> mData = new ArrayList<>();
    
    @Override
    public DemoMainFragmentBinding getViewBinding(ViewGroup container) {
        return DemoMainFragmentBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected void initView() {
        mData.add(new DemoItem("测试滑动删除", "", () -> {
            startActivity(new Intent(requireContext(), SecondActivity.class));
        }));
        mData.add(new DemoItem("MVVM", "", () -> {
            startActivity(new Intent(requireContext(), DemoMvvmActivity.class));
        }));
        mData.add(new DemoItem("网络", "", () -> {
            startActivity(new Intent(requireContext(), DemoNetworkActivity.class));
        }));
        mData.add(new DemoItem("DataStore", "", () -> {
            startActivity(new Intent(requireContext(), DemoDataStoreActivity.class));
        }));
        mData.add(new DemoItem("数据库", "", () -> {
            startActivity(new Intent(requireContext(), DemoDatabaseActivity.class));
        }));
        mData.add(new DemoItem("权限", "", () -> {
            startActivity(new Intent(requireContext(), DemoPermissionActivity.class));
        }));
        mData.add(new DemoItem("RecyclerView", "", () -> {
            startActivity(new Intent(requireContext(), DemoRecyclerViewActivity.class));
        }));
        mData.add(new DemoItem("Fragment", "", () -> {
            Bundle bundle = new Bundle();
            bundle.putString("userName", "Allever");
            DemoFragmentActivity.start(requireActivity(), DemoContentFragment.class, bundle);
        }));
        mData.add(new DemoItem("Mvvm Fragment", "", () -> {
            startActivity(new Intent(requireContext(), DemoMvvmFragmentActivity.class));
        }));
        mData.add(new DemoItem("Ripple", "", () -> {
            startActivity(new Intent(requireContext(), DemoRippleActivity.class));
        }));
        mData.add(new DemoItem("BaseTitleActivity", "", () -> {
            startActivity(new Intent(requireContext(), DemoMyTitleActivity.class));
        }));
        mData.add(new DemoItem("TitleFragmentActivity", "", () -> {
            Bundle bundle = new Bundle();
            bundle.putString("content", "Allever");
            DemoFragmentTitleActivity.start(requireActivity(), DemoContentFragment.class, "TitleFragmentActivity", bundle);
        }));
        mData.add(new DemoItem("ImageLoader", "Glide ImageLoader", () -> {
            DemoFragmentTitleActivity.start(requireActivity(), DemoImageLoaderFragment.class, "ImageLoader", null);
        }));
        mData.add(new DemoItem("TabFragment", "TabLayout + ViewPager2\ncom.github.li-xiaojun:FlycoTabLayout:2.0.6", () -> {
            DemoFragmentTitleActivity.start(requireActivity(), DemoMyTabFragment.class, "TabViewPager", null);
        }));

        //adapter
        DemoItemAdapter adapter = new DemoItemAdapter(mData);
        mBinding.rvFunc.setLayoutManager(new LinearLayoutManager(requireContext()));
        mBinding.rvFunc.setAdapter(adapter);
        adapter.setItemClickListener((item, position) -> {
            if (item.getAction() != null) {
                item.getAction().run();
            }
        });
    }

    @Override
    protected void initData() {

    }


}
