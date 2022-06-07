package com.example.meetandmeet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Get_FriendData extends Fragment {
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_get_frienddata,container,false);


        Log.e("Frag","Get_FriendData");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}