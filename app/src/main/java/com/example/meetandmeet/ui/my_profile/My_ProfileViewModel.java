package com.example.meetandmeet.ui.my_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class My_ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public My_ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("내정보 화면 페이지 입니다.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}