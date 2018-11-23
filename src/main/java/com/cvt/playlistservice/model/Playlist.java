package com.cvt.playlistservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "playlist")
public class Playlist {
    @Id
    private String playlistId;
    @Size(min = 2, message = "Playlist name should have atleast two characters.")
    private String playlistName;
    @NotNull(message = "Playlist must have description")
    private String playlistDescription;
    @NotNull(message = "Date cannot be empty")
    private String dateAdded;
    @NotNull(message = "Playlist must have a song")
    private String userId;

    public Playlist(String playlistId, String playlistName, String playlistDescription, String dateAdded, String userId) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
        this.dateAdded = dateAdded;
        this.userId = userId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getUserId() {
        return userId;
    }
}
