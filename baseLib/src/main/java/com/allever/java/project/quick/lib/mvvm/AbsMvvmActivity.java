package com.allever.java.project.quick.lib.mvvm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.allever.java.project.quick.lib.ui.AbsBindingActivity;

import java.lang.reflect.ParameterizedType;

public abstract class AbsMvvmActivity<VB extends ViewBinding, VM extends AbsViewModel> extends AbsBindingActivity<VB> {

    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mViewModel = createVM();
        super.onCreate(savedInstanceState);
        initObserver();
    }

    private VM createVM() {
        return new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                try {
                    return modelClass.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }).get((Class<VM>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    }

    public abstract void initObserver();
}
