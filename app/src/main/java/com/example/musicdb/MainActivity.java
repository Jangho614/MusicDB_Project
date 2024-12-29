package com.example.musicdb;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // 각 fragment 클래스의 변수 선언
    PlayFragment play;
    PlaylistFragment song;
    UploadFragment home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = new UploadFragment();
        song = new PlaylistFragment();
        play = new PlayFragment();

        // 하단바 메뉴 변수 선언
        BottomNavigationView bottomMenu = findViewById(R.id.bottom_menu);
        // 기본 시작 화면 지정
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, song).commit();

        //하단바 아이템 기본 선택 지정
        bottomMenu.setSelectedItemId(R.id.song);
        bottomMenu.setItemIconTintList(null);

        // 각 아이템이 클릭되었을 때 수행될 동작
        bottomMenu.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        // 아이템의 아이디 호출
                        switch (item.getItemId()) {
                            case R.id.song:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, song).commit();
                                return true;
                            case R.id.play:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, play).commit();
                                return true;
                            case R.id.home:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, home).commit();
                                return true;
                        }
                        return false;
                    }
                }
        );
    }
}