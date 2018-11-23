package com.cvt.playlistservice.controller;

import com.cvt.playlistservice.model.Playlist;
import com.cvt.playlistservice.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<Playlist> getAllPlaylist(){
        return playlistService.getAllPlaylist();
    }

    @GetMapping("/users/{userId}")
    public List<Playlist> getAllPlaylistOfUser(@PathVariable String userId){
        return playlistService.getAllPlaylistOfUser(userId);
    }

    @GetMapping("{playlistId}")
    public Playlist getPlaylistById(@PathVariable String playlistId){
        return playlistService.getPlaylistById(playlistId);
    }

    @PostMapping
    public ResponseEntity<Object> savePlaylist(@Valid @RequestBody Playlist playlist){
        playlistService.savePlaylist(playlist);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(playlist.getPlaylistId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{playlistId}")
    public void deletePlaylist(@PathVariable String playlistId){
        playlistService.deletePlaylist(playlistId);
    }

    @PutMapping("{playlistId}")
    public void updatePlaylist(@PathVariable String playlistId, @Valid @RequestBody Playlist playlist){
        playlistService.updatePlaylistById(playlistId, playlist);
    }
}
