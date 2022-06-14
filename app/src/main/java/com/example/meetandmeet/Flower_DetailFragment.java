package com.example.meetandmeet;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.databinding.DataBindingUtil;


import com.iammert.tileprogressview.TiledProgressView;
import com.skyhope.materialtagview.TagView;

public class Flower_DetailFragment extends Fragment implements EditDialogFragment.OnInputSelected{

    Context context;
    TextView nameText,birthText,telText;
    ImageButton modify;
    TiledProgressView pgb; //progress bar
    private static final String TAG = "Flower_DetailFragment";



    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: found incoming input: " + input);
        //textView에 표시
        nameText  .setText(input);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_flower_detail, container, false);
        context = container.getContext();
        modify=(ImageButton) view.findViewById(R.id.modify);
        nameText=(TextView) view.findViewById(R.id.nameTv);
        birthText=(TextView) view.findViewById(R.id.birthdayTV);
        telText=(TextView) view.findViewById(R.id.phoneTv);
        pgb=(TiledProgressView)view.findViewById(R.id.progressBar);

        TagView tagView1 = (TagView) view.findViewById(R.id.tag_rem);
        TagView tagView2 = (TagView) view.findViewById(R.id.tag_like);
        TagView tagView3 = (TagView) view.findViewById(R.id.tag_hate);
        TagView tagView4 = (TagView) view.findViewById(R.id.tag_ect);


        tagView1.setHint("이 분에 대해 기억해야 될 것은 무엇인가요?");
        tagView2.setHint("이 분이 좋아하시는 것은 무엇인가요?");
        tagView3.setHint("이 분이 싫어하시는 것은 무엇인가요?");
        tagView4.setHint("그 밖에 여러가지 입력해보세요");

        tagView1.addTagLimit(10);
        tagView2.addTagLimit(10);
        tagView3.addTagLimit(10);
        tagView4.addTagLimit(10);

        String[] tagList1 = new String[]{"돼정이", "과일러버", "7/3 동탄"};
        tagView1.setTagList(tagList1);

        //데이터 베이스 연결
//        FirebaseDatabase db=FirebaseDatabase.getInstance();
//        DatabaseReference myRef=db.getReference("message");
//        myRef.setValue(tagList1);

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String value=snapshot.getValue(String.class);
//                tagView1.setTagList("value"+value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        String[] tagList2 = new String[]{"떡볶이", "체리", "곱창"};
        tagView2.setTagList(tagList2);
        String[] tagList3 = new String[]{"우유", "비계", "화내기"};
        tagView3.setTagList(tagList3);
        String[] tagList4 = new String[]{"양양여행", "술찌", "코딩"};
        tagView4.setTagList(tagList4);


        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: opening dialog");
//                new EditDialogFragment().show(
//                        getChildFragmentManager(), Flower_DetailFragment.TAG);
                EditDialogFragment dialog = new EditDialogFragment();
//                dialog.setTargetFragment();
                dialog.show(getActivity().getSupportFragmentManager(), "EditDialogFragment");
            }
        });


        //progress bar 설정
        pgb.setProgress(30f);    //30%

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
