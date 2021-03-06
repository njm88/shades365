package com.tinker.shades365.ui.colorwheel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tinker.shades365.ColorStateListCreator;
import com.tinker.shades365.R;

public class ColorWheelFragment extends Fragment {

    private ColorWheelViewModel colorWheelViewModel;
    private ColorPickerView colorPickerView;
    private BottomNavigationView bottomNavigationView;

    private OnColorChangedListener onColorChangedListener = new OnColorChangedListener() {
        @Override
        public void onColorChanged(int selectedColor) {
            setEnabledNavigationIconToColor(selectedColor);
        }
    };

    private void setEnabledNavigationIconToColor(int color) {
        bottomNavigationView.setItemIconTintList(
                ColorStateListCreator.create(color, ContextCompat.getColor(getContext(), R.color.colorStars)));
    }

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

        bottomNavigationView = getActivity().findViewById(R.id.nav_view);

        colorPickerView = root.findViewById(R.id.color_picker_view);
        colorPickerView.addOnColorChangedListener(onColorChangedListener);

        return root;
    }
}