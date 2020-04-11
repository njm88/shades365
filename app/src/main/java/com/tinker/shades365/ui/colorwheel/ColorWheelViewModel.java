package com.tinker.shades365.ui.colorwheel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ColorWheelViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ColorWheelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is color wheel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}