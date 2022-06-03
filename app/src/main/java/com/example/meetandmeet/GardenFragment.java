package com.example.meetandmeet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GardenFragment extends Fragment {

    private RecyclerView recyclerView;
    private GardenViewAdapter adapter;
    private ArrayList<itemVO> list = new ArrayList<>();

    @Nullable
    @Override
    //프레그먼트가 보여줄 뷰의 레아아웃 파일인 fragment_home.xml 문서와 연결되도록 뷰바인딩에서 자동으로 만들어지는 바인딩 클래스를 통해 뷰객체 생성(inflate)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_garden,container,false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);

        list = itemVO.createContactsList(10);
        recyclerView.setHasFixedSize(true);
        adapter = new GardenViewAdapter(getActivity(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        Log.e("Frag","Gardenfragment");
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}



