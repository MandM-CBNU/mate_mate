package com.example.meetandmeet;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class itemVO{
    int imgResId;
    String name;
    String email;
    String intro;

    //화면에 표시될 문자열 초기화
    public itemVO(int imgResId, String name, String email, String intro) {
        this.imgResId = imgResId;
        this.name = name;
        this.email = email;
        this.intro = intro;
    }
}




