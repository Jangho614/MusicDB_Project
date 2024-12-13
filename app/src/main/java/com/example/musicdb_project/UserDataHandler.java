package com.example.musicdb_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class UserDataHandler {
    private static SQLite_Helper dbHelper;

    public UserDataHandler(Context context) {
        dbHelper = new SQLite_Helper(context);
    }

    // 사용자 데이터 삽입 메서드 (기존)
    public static long insertUser(String userId, String name, String email, int age) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", userId);
        values.put("name", name);
        values.put("email", email);
        values.put("age", age);
        long rowId = db.insert("users", null, values);
        db.close();
        return rowId;
    }

    // 사용자 데이터 조회 메서드
    public List<String> getAllUsers() {
        List<String> userList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM users";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String userData = "ID: " + cursor.getString(cursor.getColumnIndexOrThrow("user_id")) +
                        ", Name: " + cursor.getString(cursor.getColumnIndexOrThrow("name")) +
                        ", Email: " + cursor.getString(cursor.getColumnIndexOrThrow("email")) +
                        ", Age: " + cursor.getInt(cursor.getColumnIndexOrThrow("age"));
                userList.add(userData);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;
    }
}
