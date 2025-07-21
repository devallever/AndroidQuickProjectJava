package com.allever.java.project.quick.demo;

import android.view.ViewGroup;

import androidx.core.content.ContextCompat;

import com.allever.java.project.quick.R;
import com.allever.java.project.quick.databinding.DemoPageImageLoaderBinding;
import com.allever.java.project.quick.lib.image.ImageLoader;
import com.allever.java.project.quick.lib.util.DisplayUtils;

public class DemoImageLoaderFragment extends DemoBaseFragment<DemoPageImageLoaderBinding> {
    private static final String url = "https://pic.rmb.bdstatic.com/bjh/events/e8d967c6c7ac8d0f2b6b8bc7b40240184034.png@h_1280";

    @Override
    public DemoPageImageLoaderBinding getViewBinding(ViewGroup container) {
        return DemoPageImageLoaderBinding.inflate(getLayoutInflater(), container, false);
    }

    @Override
    protected void initView() {
        ImageLoader.loadImage(mBinding.ivNormal, url);
        ImageLoader.loadRound(mBinding.ivRound, url, DisplayUtils.dp2px(getContext(), 10));
        ImageLoader.loadCircle(mBinding.ivCircle, url);
        ImageLoader.loadBroderCircle(mBinding.ivCircleBorder, url, DisplayUtils.dp2px(getContext(), 1), ContextCompat.getColor(requireContext(), R.color.white));
        ImageLoader.loadBlur(mBinding.ivBlur, url);
    }

    @Override
    protected void initData() {

    }
}
