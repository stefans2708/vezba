package com.android.htec.vezba;

import android.arch.lifecycle.ViewModelProviders;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.htec.vezba.databinding.ActivityMainBinding;
import com.android.htec.vezba.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding.setViewModel(viewModel);
    }

}
