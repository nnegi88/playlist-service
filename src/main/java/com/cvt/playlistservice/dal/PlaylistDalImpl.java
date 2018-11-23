package com.cvt.playlistservice.dal;

import com.cvt.playlistservice.model.Playlist;
import com.cvt.playlistservice.model.PlaylistNotFoundException;
import com.cvt.playlistservice.model.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistDalImpl implements PlaylistDal {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Playlist> getAllPlaylist() {
        return mongoTemplate.findAll(Playlist.class);
    }

    @Override
    public List<Playlist> getAllPlaylistOfUser(String userId) throws UserNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<Playlist> playlists = mongoTemplate.find(query, Playlist.class);
        if(playlists==null) throw new UserNotFoundException(userId);
        return playlists;
    }

    @Override
    public Playlist getPlaylistById(String playlistId) throws PlaylistNotFoundException{
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(playlistId));
        Playlist playlist = mongoTemplate.findOne(query, Playlist.class);
        if(playlist==null) throw new PlaylistNotFoundException(playlistId);
        return playlist;
    }

    @Override
    public void updatePlaylistById(String playlistId, Playlist playlist) {
        Playlist updatedPlaylist = getPlaylistById(playlistId);
        updatedPlaylist = playlist;
        mongoTemplate.save(updatedPlaylist);
    }

    @Override
    public void savePlaylist(Playlist playlist) {
        mongoTemplate.save(playlist);
    }

    @Override
    public void deletePlaylist(String playlistId) throws PlaylistNotFoundException{
        mongoTemplate.remove(getPlaylistById(playlistId));
    }
}
