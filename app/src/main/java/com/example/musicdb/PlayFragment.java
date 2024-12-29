package com.example.musicdb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlayFragment extends Fragment {

    public static final String ARG_YOUTUBE_URL = "youtube_url";
    public static final String ARG_SONG_TITLE = "song_title";
    public static final String ARG_SONG_ARTIST = "song_artist";
    public static final String ARG_SONG_GENRE = "song_genre";
    public static final String ARG_SONG_DESCRIPTION = "song_description";

    public static PlayFragment newInstance(String youtubeUrl, String title, String artist, String genre, String description) {
        PlayFragment fragment = new PlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_YOUTUBE_URL, youtubeUrl);
        args.putString(ARG_SONG_TITLE, title);
        args.putString(ARG_SONG_ARTIST, artist);
        args.putString(ARG_SONG_GENRE, genre);
        args.putString(ARG_SONG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);

        WebView webView = view.findViewById(R.id.webView);
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView artistTextView = view.findViewById(R.id.artistTextView);
        TextView genreTextView = view.findViewById(R.id.genreTextView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);

        if (getArguments() != null) {
            String youtubeUrl = getArguments().getString(ARG_YOUTUBE_URL);
            String title = getArguments().getString(ARG_SONG_TITLE);
            String artist = getArguments().getString(ARG_SONG_ARTIST);
            String genre = getArguments().getString(ARG_SONG_GENRE);
            String description = getArguments().getString(ARG_SONG_DESCRIPTION);

            // Set song information
            titleTextView.setText(title);
            artistTextView.setText(artist);
            genreTextView.setText(genre);
            descriptionTextView.setText(description);

            // Load YouTube URL
            if (youtubeUrl != null) {
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(youtubeUrl);
            }
        }

        return view;
    }
}
