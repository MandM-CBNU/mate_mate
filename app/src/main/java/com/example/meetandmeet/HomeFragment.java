package com.example.meetandmeet;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {
    //물주기 버튼 클릭 시 카카오톡 앱 실행하기 위해 선언
    private Intent intent1;
    private final String packageName = "com.kakao.talk";

    @Nullable
    @Override
    //프레그먼트가 보여줄 뷰의 레아아웃 파일인 fragment_home.xml 문서와 연결되도록 뷰바인딩에서 자동으로 만들어지는 바인딩 클래스를 통해 뷰객체 생성(inflate)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);


        Button waterbtn = (Button)rootView.findViewById(R.id.waterbtn);
        EditText Phone= (EditText) rootView.findViewById(R.id.edit_phone);


        // 연락처 입력시 하이픈(-) 자동 입력
//        Phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher("KR"));




        Log.e("Frag","Homefragment");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
