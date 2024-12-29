package com.example.musicdb;

public class Song {
    private int id;
    private String title;
    private String genre;
    private String artist;
    private String youtubeUrl;
    private String description;

    public Song(int id, String title, String genre, String artist, String youtubeUrl, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.youtubeUrl = youtubeUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public String getDescription() {
        return description;
    }
}