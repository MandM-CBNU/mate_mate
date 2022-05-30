package com.example.meetandmeet;
import android.icu.lang.UCharacter;
import java.util.ArrayList;

public class itemVO {
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

    //입력받은 숫자의 리스트 생성
    public static ArrayList<itemVO> createContactsList(int numContacts) {
        ArrayList<itemVO> contacts = new ArrayList<itemVO>();

        contacts.add(new itemVO(R.drawable.blankpot, "이진희", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.secondpot, "김예진", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.thirdpot, "이예빈", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.firstpot, "장민경", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.forth_1monthpot, "최영재", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.blankpot, "양유정", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.secondpot, "장수민", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.thirdpot, "오수미", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.firstpot, "김신영", "ok373737@naver.com", "간단한 소개를 적습니다."));
        contacts.add(new itemVO(R.drawable.forth_1monthpot, "이진희", "ok373737@naver.com", "간단한 소개를 적습니다."));

            return contacts;
        }
    }



