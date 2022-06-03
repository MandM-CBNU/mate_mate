package com.example.meetandmeet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
public class Flower_InfoFragment extends Fragment {

    private int[] posterID = {
            R.drawable.flwr1, R.drawable.flwr2, R.drawable.flwr3,
            R.drawable.flwr4, R.drawable.flwr5, R.drawable.flwr6,
            R.drawable.flwr7, R.drawable.flwr8, R.drawable.flwr9,
            R.drawable.flwr10, R.drawable.flwr11, R.drawable.flwr12
    };
    private String[] msgID = {//Todo.꽃말 설명 글로 변경 필요
            "1월입니다.",
            "2월입니다.",
            "3월입니다.",
            "4월입니다.",
            "5월입니다.",
            "6월입니다.",
            "7월입니다.",
            "8월입니다.",
            "9월입니다.",
            "10월입니다.",
            "11월입니다.",
            "12월입니다."
    };
    private Flower_InfoAdapter adapter=null;
    private GridView gridView=null;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_flower_info, container, false);
        gridView=(GridView)view.findViewById(R.id.flwrgridview);
        adapter=new Flower_InfoAdapter(getActivity(),posterID,msgID);
        gridView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}