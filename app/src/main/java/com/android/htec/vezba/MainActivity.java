package com.android.htec.vezba;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.android.htec.vezba.databinding.ActivityMainBinding;
import com.android.htec.vezba.dialog.ImageDialogFragment;
import com.android.htec.vezba.launchmode.LaunchModesActivity;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_launch_modes:
                startActivity(new Intent(this, LaunchModesActivity.class));
            case R.id.menuitem_dialogs:
                new ImageDialogFragment().show(getFragmentManager(), "tag");
        }

        return super.onOptionsItemSelected(item);
    }

}
