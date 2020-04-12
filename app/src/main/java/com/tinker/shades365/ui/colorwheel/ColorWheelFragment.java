package com.tinker.shades365.ui.colorwheel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tinker.shades365.R;

public class ColorWheelFragment extends Fragment {

    private ColorWheelViewModel colorWheelViewModel;
    ColorPickerView colorPickerView;
    BottomNavigationView bottomNavigationView;

    private OnColorChangedListener onColorChangedListener = new OnColorChangedListener() {
        @Override
        public void onColorChanged(int selectedColor) {
            Log.i("Test", "Changed color to: " + selectedColor);
            bottomNavigationView.setOutlineAmbientShadowColor(selectedColor);
            bottomNavigationView.setOutlineSpotShadowColor(selectedColor);
        }
    };

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

        bottomNavigationView = root.findViewById(R.id.nav_view);

        colorPickerView = root.findViewById(R.id.color_picker_view);
        colorPickerView.addOnColorChangedListener(onColorChangedListener);

        return root;
    }
}