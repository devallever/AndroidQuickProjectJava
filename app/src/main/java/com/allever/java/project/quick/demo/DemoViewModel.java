package com.allever.java.project.quick.demo;

import androidx.lifecycle.MutableLiveData;

import com.allever.java.project.quick.lib.mvvm.AbsViewModel;

public class DemoViewModel extends AbsViewModel {

    public MutableLiveData<String> counterLiveData = new MutableLiveData<>();
    private int counter = 0;

    public void updateCounter() {
        counter++;
        counterLiveData.setValue(String.valueOf(counter));
    }
}
