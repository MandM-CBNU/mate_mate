package com.example.meetandmeet.ui.flower_detail;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.meetandmeet.R;
//일단 기능 구현을 위해 adtivity로
public class Flower_DetailFragment extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_flower_detail);
    }
}