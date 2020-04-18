package com.android.htec.vezba;

import android.app.TimePickerDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.htec.vezba.databinding.ActivityMainBinding;
import com.android.htec.vezba.dialog.ImageDialogFragment;
import com.android.htec.vezba.launchmode.LaunchModesActivity;
import com.android.htec.vezba.viewmodel.MainActivityViewModel;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding.setViewModel(viewModel);
        setSupportActionBar(binding.appBar.findViewById(R.id.toolbar));

        initViews();
        setObservers();
    }

    private void initViews() {
        binding.timePicker.setIs24HourView(true);
        binding.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Selected time is: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setObservers() {
        viewModel.getBtnTimePicker().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                showTimePickerDialog();
            }
        });

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

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "You selected: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePickerDialog.show();
    }

}
