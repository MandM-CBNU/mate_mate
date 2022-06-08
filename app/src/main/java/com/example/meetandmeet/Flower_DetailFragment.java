package com.example.meetandmeet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Flower_DetailFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_flower_detail, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
