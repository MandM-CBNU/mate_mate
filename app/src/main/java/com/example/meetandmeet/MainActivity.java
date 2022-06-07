package com.example.meetandmeet;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.net.HttpCookie;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActionMenuView actionMenuView;

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    // 3개의 메뉴에 들어갈 Fragment들
    HomeFragment homeFragment = new HomeFragment();
    GardenFragment gardenFragment = new GardenFragment();
    Flower_InfoFragment flower_infoFragment = new Flower_InfoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view);

        //첫화면 지정
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, homeFragment).commitAllowingStateLoss();
        //바텀 네비 홈으로 설정
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.navigation_garden:
                        replaceFragment(new GardenFragment());
                        break;
                    case R.id.navigation_flower_info:
                        replaceFragment(new Flower_InfoFragment());
                        break;
                    case R.id.navigation_calendar:
                        replaceFragment(new CalendarFragment());
                        break;

                }
                return true;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_nav_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_myprofile:
                replaceFragment(new MyProfile_Fragment());
                return true;
            case R.id.menu_settings:
                replaceFragment(new SettingFragment());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //프래그먼트 교체 명령어 (프래그먼트에서 하단 메뉴바 없이 다른 프래그먼트로 이동시 사용)
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //프래그먼트 화면 전환시 애니매이션
        //fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right,R.anim.enter_from_right,R.anim.enter_from_right);

        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

