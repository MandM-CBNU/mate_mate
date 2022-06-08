package com.example.meetandmeet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyProfile_Fragment extends Fragment {

    @Nullable
    @Override
    //프레그먼트가 보여줄 뷰의 레아아웃 파일인 fragment_home.xml 문서와 연결되도록 뷰바인딩에서 자동으로 만들어지는 바인딩 클래스를 통해 뷰객체 생성(inflate)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_profile_,container,false);


        Log.e("Frag","MyProfile_Fragment");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}