package com.example.meetandmeet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import  com.example.meetandmeet.databinding.FragmentTaskListBinding;


import java.util.ArrayList;
import java.util.List;

public class TaskListFragment extends Fragment {
    private FragmentTaskListBinding binding;
    private DetailsFragment detailsFragment = new DetailsFragment();
    RecyclerViewAdapter recyclerViewAdapter;
    private static ArrayList<Item> list = new ArrayList<>();
    // private static List<Item> list2 = new ArrayList<>();
    RecyclerView recyclerView;
    //데이터 베이스 선언
    private static DatabaseReference mDatabase;
    static Friends friend;

    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //데이터
        mDatabase = FirebaseDatabase.getInstance().getReference(); //DatabaseReference의 인스턴스
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_list, container, false);
        recyclerView = binding.recyclerView;
        //list = createFriendsList();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        // list = createFriendsList();


        list.add(new Item("이진희 씨의 화분",
                "010-3407-1511",
                "2020/06/07",
                50,
                R.drawable.firstpot));
        list.add(new Item("이민희 씨의 화분",
                "010-2315-1632",
                "2000/05/04",
                30,
                R.drawable.secondpot));
        list.add(new Item("임수연 씨의 화분",
                "456-654-6545",
                "2006/56/89",
                45,
                R.drawable.thirdpot));
        list.add(new Item("서민정 씨의 화분",
                "121-654-6542",
                "2007/06/08",
                90,
                R.drawable.forth_1monthpot));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        binding.recyclerView.setAdapter(adapter);
        adapter.setListener((v,position) -> {
            viewModel.setSelected(adapter.getItemAt(position));
            getParentFragmentManager().beginTransaction().replace(R.id.framelayout,detailsFragment).addToBackStack(null).commit();
        });
    }

    //입력받은 숫자의 리스트 생성
    public ArrayList<Item> createFriendsList() {

        ArrayList<Item> friends = new ArrayList<Item>();

        for(int n=1;n<=var_friend.i;n++){
            String s=String.valueOf(n);
            mDatabase.child("Friends").child(s).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    friend = snapshot.getValue(Friends.class);
                    friends.add(new Item(friend.name,friend.phone,friend.birth,friend.progressNum,R.drawable.blankpot));
                    //이 리스트들을 어댑터에 넣어진다.
                    recyclerView.setHasFixedSize(true);
                    recyclerViewAdapter = new RecyclerViewAdapter(list);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) { //참조에 액세스 할 수 없을 때 호출
                }
            });

        }
        return friends;
    }
}