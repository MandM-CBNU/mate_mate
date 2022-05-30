package com.example.meetandmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;
=======
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
>>>>>>> 678713163f33d7f1c162d00103c243744d5697a7

import com.example.meetandmeet.ui.flower_detail.Flower_DetailFragment;
import com.example.meetandmeet.ui.home.HomeFragment;
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

<<<<<<< HEAD
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_garden, R.id.navigation_flower_info)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Intent intent=new Intent(getApplicationContext(), Flower_DetailFragment.class);
        startActivity(intent);

        //main 화분 개수 >3개로 임의 설정
        Button pot[]=new Button[3];
        Integer btnId[]={R.id.mainpotBtn1,R.id.mainpotBtn2,R.id.mainpotBtn3};
        for(int i=0;i<btnId.length;i++){
            final int index;
            index=i;
            pot[index]=(Button) findViewById(btnId[index]);
            //화분 밑 상세페이지 버튼 클릭 시 동작
            pot[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(),Flower_DetailFragment.class);
                    intent.putExtra("potID",index); //potID 받아옴
                    //intent.putExtra("potName",btn_text);    //버튼에 쓰여있는 text를 받아오는 방법도 있을 수 있읍
                }
            });
        }
=======
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

>>>>>>> 678713163f33d7f1c162d00103c243744d5697a7
    }
}