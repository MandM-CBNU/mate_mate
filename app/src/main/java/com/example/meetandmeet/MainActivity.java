package com.example.meetandmeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.meetandmeet.ui.flower_detail.Flower_DetailFragment;
import com.example.meetandmeet.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.adapter.FragmentViewHolder;

import com.example.meetandmeet.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_nav_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.modechange:
                Toast.makeText(getApplicationContext(),"모드변경 버튼 클릭됨",Toast.LENGTH_LONG).show();
                break;
            case R.id.myprofile:
                binding = ActivityMainBinding.inflate(getLayoutInflater());
                setContentView(binding.getRoot());

                break;
        }
        return true;
        }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    }

}