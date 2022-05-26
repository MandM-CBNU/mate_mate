package com.example.meetandmeet;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

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
                        //fragmentTransaction.replace(R.id.framelayout,homeFragment).commitAllowingStateLoss();
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new HomeFragment()).commit();
                        break;
                    case R.id.navigation_garden:
                        //fragmentTransaction.replace(R.id.framelayout,gardenFragment).commitAllowingStateLoss();
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new GardenFragment()).commit();
                        break;
                    case R.id.navigation_flower_info:
                        //fragmentTransaction.replace(R.id.framelayout,flower_infoFragment).commitAllowingStateLoss();
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Flower_InfoFragment()).commit();
                        break;
                    case R.id.navigation_calendar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new CalendarFragment()).commit();
                        break;

                }
                return true;
            }
        });

    }
}