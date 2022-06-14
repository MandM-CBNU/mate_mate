package com.example.meetandmeet;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Get_FriendData extends Fragment {

    //get fiend data를 위해 선언
    private DatabaseReference mDatabase;
    Button save;
    EditText phone, name;
    DatePicker birth;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_get_frienddata,container,false);


        Log.e("Frag","Get_FriendData");
        mDatabase = FirebaseDatabase.getInstance().getReference(); //DatabaseReference의 인스턴스
        Button save = (Button) rootView.findViewById(R.id.submit);
        name = (EditText) rootView.findViewById(R.id.name);
        phone = (EditText)rootView.findViewById(R.id.edit_phone);
        birth=(DatePicker)rootView.findViewById(R.id.birth);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUserName = name.getText().toString();
                String getUserPhone = phone.getText().toString();
                long birthTime = birth.getCalendarView().getDate();
                Date birth = new Date(birthTime);
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String getUserBirth = dateFormat.format(birth);
                HashMap result = new HashMap<>();
                result.put("name", getUserName); //키, 값
                result.put("phone", getUserPhone);
                result.put("birth", getUserBirth);

                writeFriend(Integer.toString(++var_friend.i), getUserName, getUserPhone, getUserBirth,R.drawable.blankpot,10);
            }
        });

        return rootView;
    }
    private void writeFriend(String userId, String name, String phone, String birth, int imgUrl, int progressNum) {
        Friends friend = new Friends(name, phone, birth,imgUrl,progressNum);

        //데이터 저장
        mDatabase.child("Friends").child(userId).setValue(friend)
                .addOnSuccessListener(new OnSuccessListener<Void>() { //데이터베이스에 넘어간 이후 처리
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(),"저장을 완료했습니다", Toast.LENGTH_LONG).show();
//                        // Create new fragment and transaction
//                        Fragment newFragment = new HomeFragment();
//                        // consider using Java coding conventions (upper first char class names!!!)
//                        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//
//                        // Replace whatever is in the fragment_container view with this fragment,
//                        // and add the transaction to the back stack
//                        transaction.replace(R.id.submit, newFragment);
//                        transaction.addToBackStack(null);
//
//                        // Commit the transaction
//                        transaction.commit();

                        Fragment fragment = new HomeFragment();

                        FragmentManager fragmentManager = getParentFragmentManager();

                        fragmentManager.beginTransaction().replace(R.id.fd, fragment).commit();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),"저장에 실패했습니다" , Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}