package com.example.meetandmeet;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    //프레그먼트가 보여줄 뷰의 레아아웃 파일인 fragment_home.xml 문서와 연결되도록 뷰바인딩에서 자동으로 만들어지는 바인딩 클래스를 통해 뷰객체 생성(inflate)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);

        ImageButton bookmarkbtn = (ImageButton)rootView.findViewById(R.id.bookmarkbtn);
        FloatingActionButton potplusbtn =(FloatingActionButton)rootView.findViewById(R.id.potplusbtn);
        ImageView mainpot1 = (ImageView) rootView.findViewById(R.id.mainpot1);
        ImageView mainpot2 = (ImageView) rootView.findViewById(R.id.mainpot2);
        ImageView mainpot3 = (ImageView) rootView.findViewById(R.id.mainpot3);
        Button mainpot1Btn = (Button) rootView.findViewById(R.id.mainpotBtn1);
        Button mainpo21Btn = (Button) rootView.findViewById(R.id.mainpotBtn2);
        Button mainpo31Btn = (Button) rootView.findViewById(R.id.mainpotBtn3);
        Button waterbtn = (Button)rootView.findViewById(R.id.waterbtn);

        bookmarkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new BookmarkFragment());

            }
        });

        waterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new Select_PotFragment());
            }
        });

        mainpot1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Log.e("Frag","Homefragment");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
