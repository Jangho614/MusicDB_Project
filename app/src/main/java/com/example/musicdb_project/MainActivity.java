package com.example.musicdb_project;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Node;
import org.w3c.dom.UserDataHandler;

public class MainActivity extends AppCompatActivity {
    private UserDataHandler userDataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDataHandler = new UserDataHandler(this) {
            @Override
            public void handle(short operation, String key, Object data, Node src, Node dst) {

            }
        };

        // 예제 데이터 삽입
        long rowId = userDataHandler.insertUser("Alice", 23);

        if (rowId != -1) {
            Toast.makeText(this, "데이터 삽입 성공: Row ID " + rowId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "데이터 삽입 실패", Toast.LENGTH_SHORT).show();
        }
    }
}
