package com.example.meetandmeet.ui.garden;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GardenViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GardenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("가든 화면 페이지 입니다");
    }

    public LiveData<String> getText() {
        return mText;
    }
}