package com.example.musicdb_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_Helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "example.db"; // 데이터베이스 이름
    private static final int DATABASE_VERSION = 1; // 데이터베이스 버전

    // 테이블 생성 SQL
    private static final String USER_TABLE =
            "CREATE TABLE users (" +
                    "u_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "email TEXT, " +
                    "age INTEGER);";
    private static final String MUSIC_TABLE =
            "CREATE TABLE Musics (" +
                    "s_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "singer TEXT, " +
                    "youtube TEXT, " +
                    "info TEXT, " +
                    "genre TEXT);";
    public SQLite_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLite_Helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE); // 테이블 생성
        db.execSQL(MUSIC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users"); // 기존 테이블 삭제
        onCreate(db); // 새 테이블 생성
    }
}
