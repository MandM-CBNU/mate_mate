package com.example.meetandmeet.ui.flower_info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Flower_InfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Flower_InfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("월별 화분 정보 페이지 입니다");
    }

    public LiveData<String> getText() {
        return mText;
    }
}