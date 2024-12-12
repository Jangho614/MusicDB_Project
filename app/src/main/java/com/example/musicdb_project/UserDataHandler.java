package com.example.musicdb_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDataHandler {
    private MyDatabaseHelper dbHelper;

    public UserDataHandler(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    // 사용자 데이터 삽입 메서드
    public long insertUser(String userId, String name, String email, int age) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("user_id", userId);
        values.put("name", name);
        values.put("email", email);
        values.put("age", age);

        long rowId = db.insert("users", null, values); // 데이터 삽입
        db.close(); // 데이터베이스 닫기
        return rowId; // 삽입된 행 ID 반환
    }
}
