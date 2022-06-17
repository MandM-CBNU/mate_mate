package com.example.meetandmeet;
/// 코드 작성자 2020039017 임수연 ///
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class BookmarkFragment extends Fragment{
    private static RecyclerView recyclerView1;
    private static BMarkViewAdapter adapter1;
    private static ArrayList<markVO> list1 = new ArrayList<>();
    private static DatabaseReference mDatabase1;
    static Friends friend1;
    public ImageView mark_img;
    public TextView mark_name;
    public TextView mark_id;
    public RadioButton markbtn;
    HashMap result;
    ViewGroup rootView;

    @Nullable
    @Override
    //프레그먼트가 보여줄 뷰의 레아아웃 파일인 fragment_bookmark.xml 문서와 연결되도록 뷰바인딩에서 자동으로 만들어지는 바인딩 클래스를 통해 뷰객체 생성(inflate)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        mDatabase1 = FirebaseDatabase.getInstance().getReference(); //DatabaseReference의 인스턴스

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_bookmark,container,false);
        recyclerView1 = (RecyclerView)rootView.findViewById(R.id.BrecyclerView);
        list1 = createBookMrkList();

        Log.e("Frag","BookmarkFragment");
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //입력받은 숫자의 리스트 생성
    public ArrayList<markVO> createBookMrkList() {
        ArrayList<markVO> Marks = new ArrayList<markVO>();

        for(int n=1;n<=var_friend.i;n++){
            String s=String.valueOf(n);

            mDatabase1.child("Friends").child(s).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    friend1 = snapshot.getValue(Friends.class);
                    Log.v("test22677222","test: "+friend1.getName());
//                    String a=friend1.getBMark();
//                    if((friend1.bmark).equals("")){
//                        Marks.add(new markVO(R.drawable.blankpot, friend1.name, s, "false"));
//                    }
//                    else if(a.equals("true")){
//                        Marks.add(new markVO(R.drawable.blankpot, friend1.name, s, "true"));
//                    }
//                    else{
                        Marks.add(new markVO(R.drawable.blankpot, friend1.name, s, friend1.bmark));
//                    }
                    
                    //이 리스트들을 어댑터에 넣어진다.
                    recyclerView1.setHasFixedSize(true);
                    adapter1 = new BMarkViewAdapter(getActivity(),list1);
                    recyclerView1.setLayoutManager(new GridLayoutManager(getContext(),3));
                    recyclerView1.setAdapter(adapter1);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) { //참조에 액세스 할 수 없을 때 호출
                }
            });

        }
        return Marks;
    }

}