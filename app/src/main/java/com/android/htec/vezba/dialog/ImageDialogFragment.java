package com.android.htec.vezba.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.htec.vezba.R;

public class ImageDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_image, container, false);
        initViews(view);
        ((ImageView) view.findViewById(R.id.image_dialog)).setImageResource(R.drawable.ic_launcher_foreground);
        return view;
    }

    private void initViews(View view) {
        Button btnYes = view.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(v -> ImageDialogFragment.this.dismiss());

        Button btnNo = view.findViewById(R.id.btn_no);
        btnNo.setOnClickListener(v -> Toast.makeText(getActivity(), "asdf", Toast.LENGTH_SHORT).show());
    }

}
