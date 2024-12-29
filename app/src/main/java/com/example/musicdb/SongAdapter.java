package com.example.musicdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);

        // Bind data
        holder.titleTextView.setText(song.getTitle());
        holder.genreTextView.setText(song.getGenre());
        holder.artistTextView.setText(song.getArtist());
//        holder.descriptionTextView.setText(song.getDescription());
        holder.playIcon.setImageResource(R.drawable.menuicon_play);

        // Set item click listener
        holder.itemView.setOnClickListener(v -> {
            PlayFragment fragment = PlayFragment.newInstance(song.getYoutubeUrl(), song.getTitle(), song.getArtist(), song.getGenre(), song.getDescription());
            //youtubeUrl, String title, String artist, String genre, String description
            // Assuming the parent Activity contains the FrameLayout with ID container
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment) // Replace container ID here
                    .addToBackStack(null)
                    .commit();
        });
    }


    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, genreTextView, artistTextView, descriptionTextView;
        ImageView playIcon;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            genreTextView = itemView.findViewById(R.id.genreTextView);
            artistTextView = itemView.findViewById(R.id.artistTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            playIcon = itemView.findViewById(R.id.songThumbnail);
        }
    }
}
