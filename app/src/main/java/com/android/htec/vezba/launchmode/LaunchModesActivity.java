package com.android.htec.vezba.launchmode;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.htec.vezba.R;

public class LaunchModesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        initButtons();
    }

    private void initButtons() {
        findViewById(R.id.btn_standard).setOnClickListener(v -> startActivity(new Intent(LaunchModesActivity.this, LaunchModesActivity.class)));
        findViewById(R.id.btn_single_top).setOnClickListener(v -> startActivity(new Intent(LaunchModesActivity.this, SingleTopActivity.class)));
        findViewById(R.id.btn_single_task).setOnClickListener(v -> startActivity(new Intent(LaunchModesActivity.this, SingleTaskActivity.class)));
        findViewById(R.id.btn_single_instance).setOnClickListener(v -> startActivity(new Intent(LaunchModesActivity.this, SingleInstanceActivity.class)));
    }

}
