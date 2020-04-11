package com.tinker.shades365.ui.colorwheel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tinker.shades365.R;

public class ColorWheelFragment extends Fragment {

    private ColorWheelViewModel colorWheelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        colorWheelViewModel =
                ViewModelProviders.of(this).get(ColorWheelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_colorwheel, container, false);
        final TextView textView = root.findViewById(R.id.text_color_wheel);
        colorWheelViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}