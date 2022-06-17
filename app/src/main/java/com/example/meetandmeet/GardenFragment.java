package com.example.meetandmeet;
/// 코드 작성자 2020069049 이진희 ///
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GardenFragment extends Fragment {

    private static RecyclerView recyclerView;
    private static GardenViewAdapter adapter;
    private static ArrayList<itemVO> list = new ArrayList<>();
    private static DatabaseReference mDatabase;
    static Friends friend;

    @Nullable
    @Override
    //프레그먼트가 보여줄 뷰의 레아아웃 파일인 fragment_home.xml 문서와 연결되도록 뷰바인딩에서 자동으로 만들어지는 바인딩 클래스를 통해 뷰객체 생성(inflate)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference(); //DatabaseReference의 인스턴스

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_garden,container,false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);

        list = createFriendsList();

        Log.e("Frag","Gardenfragment");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //입력받은 숫자의 리스트 생성
    public ArrayList<itemVO> createFriendsList() {

        ArrayList<itemVO> friends = new ArrayList<itemVO>();

        for(int n=1;n<=var_friend.i;n++){
            String s=String.valueOf(n);
            mDatabase.child("Friends").child(s).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    friend = snapshot.getValue(Friends.class);
                    friends.add(new itemVO(R.drawable.blankpot, friend.name, friend.birth, friend.phone));
                    //이 리스트들을 어댑터에 넣어진다.
                    recyclerView.setHasFixedSize(true);
                    adapter = new GardenViewAdapter(getActivity(),list);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) { //참조에 액세스 할 수 없을 때 호출
                }
            });

        }
        return friends;
    }
}



