package com.android.htec.vezba.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

public class MainActivityViewModel extends ViewModel {

    private ObservableField<String> countValue = new ObservableField<>("0");
    private MutableLiveData<Boolean> btnTimePicker = new MutableLiveData<>();

    public void onButtonIncrementClick() {
        countValue.set(String.valueOf(Integer.valueOf(countValue.get()) + 1));
    }

    public void onTimePickerButtonClick() {
        btnTimePicker.setValue(true);
    }

    public ObservableField<String> getCountValue() {
        return countValue;
    }

    public LiveData<Boolean> getBtnTimePicker() {
        return btnTimePicker;
    }
}
