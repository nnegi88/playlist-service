package com.cvt.playlistservice.service;

import com.cvt.playlistservice.dal.PlaylistDal;
import com.cvt.playlistservice.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistDal playlistDal;

    @Override
    public List<Playlist> getAllPlaylist() { return playlistDal.getAllPlaylist(); }

    @Override
    public List<Playlist> getAllPlaylistOfUser(String userId){
        return playlistDal.getAllPlaylistOfUser(userId);
    }

    @Override
    public Playlist getPlaylistById(String playlistId){
        return playlistDal.getPlaylistById(playlistId);
    }

    @Override
    public void savePlaylist(Playlist playlist){
        playlistDal.savePlaylist(playlist);
    }

    @Override
    public void updatePlaylistById(String playlistId, Playlist playlist) {
        playlistDal.updatePlaylistById(playlistId, playlist);
    }

    @Override
    public void deletePlaylist(String playlistId){
        playlistDal.deletePlaylist(playlistId);
    }
}
