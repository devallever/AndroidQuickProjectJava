package com.allever.java.project.quick.demo;

import com.allever.java.project.quick.databinding.DemoActivityNetworkBinding;
import com.allever.java.project.quick.demo.network.NetworkRepository;
import com.allever.java.project.quick.lib.util.GsonUtils;

public class DemoNetworkActivity extends DemoBaseActivity<DemoActivityNetworkBinding> {
    @Override
    protected DemoActivityNetworkBinding getViewBinding() {
        return DemoActivityNetworkBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        mBinding.btnNetwork.setOnClickListener(v -> {
            handleNetwork();
        });
    }

    @Override
    protected void initData() {

    }

    private void handleNetwork() {
        NetworkRepository.getIns().getNetworkData(data -> {
            mBinding.tvResult.setText(GsonUtils.toJson(data));
        });
    }
}
