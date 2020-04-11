package com.tinker.shades365.ui.quickselector;

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

public class QuickSelectorFragment extends Fragment {

    private QuickSelectorViewModel quickSelectorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quickSelectorViewModel =
                ViewModelProviders.of(this).get(QuickSelectorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_quickselector, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        quickSelectorViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}