package com.cvt.playlistservice.dal;

import com.cvt.playlistservice.model.Playlist;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlaylistDal {
    List<Playlist> getAllPlaylist();
    List<Playlist> getAllPlaylistOfUser(String userId);
    Playlist getPlaylistById(String playlistId);
    void updatePlaylistById(String playlistId, Playlist playlist);
    void savePlaylist(Playlist playlist);
    void deletePlaylist(String playlistId);
}
