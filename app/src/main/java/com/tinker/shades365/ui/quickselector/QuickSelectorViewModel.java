package com.tinker.shades365.ui.quickselector;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuickSelectorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuickSelectorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is quick selector fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}