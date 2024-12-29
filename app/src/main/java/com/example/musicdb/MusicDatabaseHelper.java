package com.example.musicdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// SQLiteOpenHelper class for managing the database in Android
public class MusicDatabaseHelper extends SQLiteOpenHelper {

    // Database constants
    private static final String DATABASE_NAME = "MusicStreaming.db";
    private static final int DATABASE_VERSION = 1;

    // Table and columns
    public static final String TABLE_SONGS = "Songs";
    public static final String COLUMN_ID = "song_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_ARTIST = "artist";
    public static final String COLUMN_YOUTUBE_URL = "youtube_url";
    public static final String COLUMN_DESCRIPTION = "description";

    // SQL statement to create the table
    private static final String CREATE_TABLE_SONGS = "CREATE TABLE " + TABLE_SONGS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TITLE + " TEXT NOT NULL, " +
            COLUMN_GENRE + " TEXT NOT NULL, " +
            COLUMN_ARTIST + " TEXT NOT NULL, " +
            COLUMN_YOUTUBE_URL + " TEXT NOT NULL, " +
            COLUMN_DESCRIPTION + " TEXT)";

    // Constructor
    public MusicDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the Songs table
        db.execSQL(CREATE_TABLE_SONGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists and create a new one
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONGS);
        onCreate(db);
    }
}
