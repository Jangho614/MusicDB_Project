package com.example.musicdb_project;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class FetchActivity extends AppCompatActivity {

    private ListView listViewUsers;
    private UserDataHandler userDataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        // UI 요소 초기화
        listViewUsers = findViewById(R.id.list_view_users);

        // 데이터베이스 핸들러 초기화
        userDataHandler = new UserDataHandler(this);

        // 데이터베이스에서 사용자 데이터 가져오기
        List<String> users = userDataHandler.getAllUsers();

        // 데이터가 있는 경우 표시, 없는 경우 메시지 출력
        if (users.isEmpty()) {
            Toast.makeText(this, "저장된 데이터가 없습니다.", Toast.LENGTH_SHORT).show();
        } else {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, users);
            listViewUsers.setAdapter(adapter);
        }
    }
}
