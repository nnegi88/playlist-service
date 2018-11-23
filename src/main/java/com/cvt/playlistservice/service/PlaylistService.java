package com.cvt.playlistservice.service;

import com.cvt.playlistservice.model.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> getAllPlaylist();
    List<Playlist> getAllPlaylistOfUser(String userId);
    Playlist getPlaylistById(String playlistId);
    void savePlaylist(Playlist playlist);
    void updatePlaylistById(String playlistId, Playlist playlist);
    void deletePlaylist(String playlistId);
}
