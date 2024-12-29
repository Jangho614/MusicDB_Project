package com.example.musicdb;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.musicdb.MusicDatabaseHelper;
import com.example.musicdb.R;

public class UploadFragment extends Fragment {

    private EditText titleInput, genreInput, artistInput, youtubeUrlInput, descriptionInput;
    private Button uploadButton;
    private MusicDatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);

        titleInput = view.findViewById(R.id.titleInput);
        genreInput = view.findViewById(R.id.genreInput);
        artistInput = view.findViewById(R.id.artistInput);
        youtubeUrlInput = view.findViewById(R.id.youtubeUrlInput);
        descriptionInput = view.findViewById(R.id.descriptionInput);
        uploadButton = view.findViewById(R.id.uploadButton);

        dbHelper = new MusicDatabaseHelper(getContext());

        uploadButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String genre = genreInput.getText().toString();
            String artist = artistInput.getText().toString();
            String youtubeUrl = youtubeUrlInput.getText().toString();
            String description = descriptionInput.getText().toString();

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(MusicDatabaseHelper.COLUMN_TITLE, title);
            values.put(MusicDatabaseHelper.COLUMN_GENRE, genre);
            values.put(MusicDatabaseHelper.COLUMN_ARTIST, artist);
            values.put(MusicDatabaseHelper.COLUMN_YOUTUBE_URL, youtubeUrl);
            values.put(MusicDatabaseHelper.COLUMN_DESCRIPTION, description);

            db.insert(MusicDatabaseHelper.TABLE_SONGS, null, values);
            Toast.makeText(getContext(), "Song uploaded successfully", Toast.LENGTH_SHORT).show();

            titleInput.setText("");
            genreInput.setText("");
            artistInput.setText("");
            youtubeUrlInput.setText("");
            descriptionInput.setText("");
        });

        return view;
    }
}