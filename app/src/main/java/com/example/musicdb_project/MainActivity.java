package com.example.musicdb_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUserId, etName, etEmail, etAge;
    private Button btnInput, btnFetch;
    private UserDataHandler userDataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 초기화
        etUserId = findViewById(R.id.input_id);
        etName = findViewById(R.id.input_name);
        etEmail = findViewById(R.id.input_email);
        etAge = findViewById(R.id.input_age);
        btnInput = findViewById(R.id.btn_input);
        btnFetch = findViewById(R.id.btn_fetch);

        // 데이터베이스 핸들러 초기화
        userDataHandler = new UserDataHandler(this);

        // 입력 버튼 클릭 이벤트 처리
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = etUserId.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String ageText = etAge.getText().toString().trim();

                // 입력 값 검증
                if (userId.isEmpty() || name.isEmpty() || email.isEmpty() || ageText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "모든 필드를 채워주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageText);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "올바른 나이를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 데이터 삽입
                long rowId = UserDataHandler.insertUser(userId, name, email, age);

                if (rowId != -1) {
                    Toast.makeText(MainActivity.this, "데이터 저장 성공!", Toast.LENGTH_SHORT).show();
                    clearInputFields(); // 입력 필드 초기화
                } else {
                    Toast.makeText(MainActivity.this, "데이터 저장 실패!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FetchActivity로 이동
                Intent intent = new Intent(MainActivity.this, FetchActivity.class);
                startActivity(intent);
            }
        });
    }

    // 입력 필드 초기화
    private void clearInputFields() {
        etUserId.setText("");
        etName.setText("");
        etEmail.setText("");
        etAge.setText("");
    }
}
