package com.android.htec.vezba.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

public class MainActivityViewModel extends ViewModel {

    private ObservableField<String> countValue = new ObservableField<>("0");


    public void onButtonIncrementClick() {
        countValue.set(String.valueOf(Integer.valueOf(countValue.get()) + 1));
    }

    public ObservableField<String> getCountValue() {
        return countValue;
    }
}
