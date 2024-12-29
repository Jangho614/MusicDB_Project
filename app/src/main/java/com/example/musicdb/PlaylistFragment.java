package com.example.musicdb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicdb.MusicDatabaseHelper;
import com.example.musicdb.R;

import java.util.ArrayList;
import java.util.List;

public class PlaylistFragment extends Fragment {

    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private MusicDatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dbHelper = new MusicDatabaseHelper(getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(MusicDatabaseHelper.TABLE_SONGS, null, null, null, null, null, null);
        List<Song> songs = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(MusicDatabaseHelper.COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MusicDatabaseHelper.COLUMN_TITLE));
            String genre = cursor.getString(cursor.getColumnIndexOrThrow(MusicDatabaseHelper.COLUMN_GENRE));
            String artist = cursor.getString(cursor.getColumnIndexOrThrow(MusicDatabaseHelper.COLUMN_ARTIST));
            String youtubeUrl = cursor.getString(cursor.getColumnIndexOrThrow(MusicDatabaseHelper.COLUMN_YOUTUBE_URL));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(MusicDatabaseHelper.COLUMN_DESCRIPTION));

            songs.add(new Song(id, title, genre, artist, youtubeUrl, description));
        }
        cursor.close();

        songAdapter = new SongAdapter(songs);
        recyclerView.setAdapter(songAdapter);

        return view;
    }
}